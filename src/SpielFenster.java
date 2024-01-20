import javax.swing.*;

public class SpielFenster {
    public SpielFenster(String title, int width, int height) {
        JFrame window = new JFrame();

        window.setTitle(title);
        window.setSize(width, height);
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
}