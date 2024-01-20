import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class SpielBackend {
    public static SpielBackend instance;
    public long deltaNano;
    public double delta;
    public int targetFPS = 60;

    public SpielBackend() {
        if (instance == null) {
            instance = this;
        }
    }

    public void onKeyPressed(KeyEvent e) {

    }
    public void onKeyReleased(KeyEvent e) {

    }

    public abstract void update();

    public abstract void draw(Graphics2D g2D);
}
