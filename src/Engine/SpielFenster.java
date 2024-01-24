package Engine;

import javax.swing.*;

/**
 * Represent the game window
 * @author Constantin Bredenbach
 * @version 0.3
 */
public class SpielFenster {
    private static int width;
    private static int height;

    /**
     * Create new window which will start the game thread and open a window
     * @param title Title at the top of the game window
     * @param width Width of the game window
     * @param height Height of the game window
     */
    public SpielFenster(String title, int width, int height) {
        JFrame window = new JFrame();

        window.setTitle(title);
        window.setSize(width, height);
        SpielFenster.width = width;
        SpielFenster.height = height;
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Fenster auf dem Bildschirm zentrieren
        window.setLocationRelativeTo(null);

        SpielPanel spielPanel = new SpielPanel();
        window.add(spielPanel);

        window.pack();

        window.setVisible(true);
        spielPanel.startGameThread();
    }

    /**
     * @return Window width
     */
    public static int getWidth() {
        return width;
    }

    /**
     * @return Window height
     */
    public static int getHeight() {
        return height;
    }
}
