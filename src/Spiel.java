import java.awt.*;
import java.awt.event.KeyEvent;

public class Spiel extends SpielBackend {
    public Spiel() {
        super(); // Nicht vergessen!
        SpielFenster spielFenster = new SpielFenster("Flappy Bird", 800, 800);
    }

    public void update() {
        /*
        if (SpielInput.isKeyPressed(KeyEvent.VK_SPACE)) {
            // Dein code..
        }
        */
    }

    public void draw(Graphics2D g2D) {
        /*
        g2D.setColor(Color.white);
        g2D.drawRect(0, 0, 100, 100);
         */
    }
}
