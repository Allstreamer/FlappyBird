package Engine;

import javax.swing.*;
import java.awt.*;

/**
 * @author Constantin Bredenbach
 * @version 0.3
 */
public class SpielPanel extends JPanel implements Runnable {
    /**
     * Thread running the game loop
     */
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

    /**
     * Starts execution of the programs game thread
     * and the game loop.
     */
    public void startGameThread() {
        gameThread = new Thread(this);
        // Starts run() in new thread to update window
        gameThread.start();
    }

    @Override
    public void run() {

        while (gameThread != null) {
            long lastTimeNS = System.nanoTime();

            // Update Game logic
            SpielBackend.instance.update();
            // Draw game
            repaint();
            // Handle Delta & Time
            final long timeToRender = System.nanoTime() - lastTimeNS;

            final long drawIntervalNano = 1_000_000_000 / SpielBackend.instance.getTargetFPS();
            final long timeToSleep = drawIntervalNano - timeToRender;
            final int nsToSleep = (int) (timeToSleep % 1_000_000);
            final long msToSleep = timeToSleep / 1_000_000;

            try {
                Thread.sleep(msToSleep, nsToSleep);
            } catch (InterruptedException e) {
                System.out.println("MS: " + msToSleep + " NS:" + nsToSleep);
                throw new RuntimeException(e);
            }

            long timeSinceLastFrameNS = System.nanoTime() - lastTimeNS;
            SpielBackend.instance.deltaNano = timeSinceLastFrameNS;
            SpielBackend.instance.delta = (double) timeSinceLastFrameNS / 1_000_000_000.0;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;
        SpielBackend.instance.draw(g2D);
        g2D.dispose();

        // Flush Graphics buffer (for linux compatibility)
        Toolkit.getDefaultToolkit().sync();
    }
}
