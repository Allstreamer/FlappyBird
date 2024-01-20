import javax.swing.*;
import java.awt.*;
import java.time.Duration;

public class SpielPanel extends JPanel implements Runnable {
    Thread gameThread;

    public SpielPanel() {
        this.setPreferredSize(new Dimension(800, 800));
        this.setBackground(Color.BLACK);

        this.addKeyListener(new SpielInput());

        // Allows for window to receive input
        this.setFocusable(true);

        // All drawing will be done in separate buffer which will
        // be "flipped" on to the screen once ready to show.
        // Prevents Flicker
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        // Starts run() in new thread to update window
        gameThread.start();
    }

    @Override
    public void run() {
        final long drawIntervalNano = 1_000_000_000 / Spiel.instance.targetFPS;

        while (gameThread != null) {
            // Don't run longer than 300 years! XD
            // will overflow otherwise
            final long start = System.nanoTime();

            // Update Game logic
            Spiel.instance.update();
            // Draw game
            repaint();

            final long end = System.nanoTime();

            // Update deltas
            Spiel.instance.deltaNano = (end - start);
            Spiel.instance.delta = (double)(end - start) / 1_000_000_000;

            try {
                // Maintain 60 FPS
                Thread.sleep(Duration.ofNanos(drawIntervalNano - Spiel.instance.deltaNano));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        Spiel.instance.draw(g2D);
        g2D.dispose();

        // Flush Graphics buffer (for linux compatibility)
        Toolkit.getDefaultToolkit().sync();
    }
}
