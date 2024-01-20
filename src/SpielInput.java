import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class SpielInput implements java.awt.event.KeyListener {
    public static SpielInput instance;
    private ArrayList<Integer> pressedKeys = new ArrayList<Integer>();
    public SpielInput() {
        super();
        if (instance == null) {
            instance = this;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Ignore
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Spiel.instance.onKeyPressed(e);
        if (!pressedKeys.contains(e.getKeyCode())) {
            pressedKeys.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Spiel.instance.onKeyReleased(e);
        // Cast to Integer to prevent Java's function overloading
        // from interpreting the integer returned by getKeyCode()
        // as an index. (God I hate Java)
        pressedKeys.remove(Integer.valueOf(e.getKeyCode()));
    }

    public static boolean isKeyPressed(int pressedKey) {
        return instance.pressedKeys.contains(pressedKey);
    }
}
