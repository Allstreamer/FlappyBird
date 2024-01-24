package Engine;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @author Constantin Bredenbach
 * @version 0.3
 */
public class SpielInput implements java.awt.event.KeyListener {
    /**
     * Global instance allowing for access from anywhere to input functionality
     */
    public static SpielInput instance;
    /**
     * Internal array for tracking which keys are currently held.
     * This array can desync with the actual keys being held if
     * the user tabs out of the application while holding a key.
     */
    private final ArrayList<Integer> pressedKeys = new ArrayList<>();

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
        SpielBackend.instance.onKeyPressed(e);
        // Prevent key modifiers adding keys into the array twice
        if (!pressedKeys.contains(e.getKeyCode())) {
            pressedKeys.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        SpielBackend.instance.onKeyReleased(e);
        // Cast to Integer to prevent Java's function overloading
        // from interpreting the integer returned by getKeyCode()
        // as an index. (God I hate Java)
        pressedKeys.remove(Integer.valueOf(e.getKeyCode()));
    }

    public static boolean isKeyPressed(int pressedKey) {
        return instance.pressedKeys.contains(pressedKey);
    }
}
