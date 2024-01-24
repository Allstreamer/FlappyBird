package Engine;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Abstract Class which provides the structure for a Spiel
 *
 * @author Constantin Bredenbach
 * @version 0.3
 */
public abstract class SpielBackend {
    /**
     * Globally Available Instance of the SpielBackend
     *
     * @see SpielBackend
     */
    public static SpielBackend instance;
    /**
     * The interval in nanoseconds from the last frame to the current one.
     */
    public long deltaNano = 0;

    /**
     * The interval in seconds from the last frame to the current one.
     */
    public double delta = 0.0;

    /**
     * Frames per Second, which the engine is trying to reach.
     * <p>
     * You may update this value while game is running in order to adjust
     * the game's framerate.
     */
    private int targetFPS = 60;

    /**
     * This needs to be called for the Game engine to function correctly
     * make sure to invoke super() in your custom class
     */
    public SpielBackend() {
        if (instance == null) {
            instance = this;
        }
    }

    public void onKeyPressed(KeyEvent e) {
    }

    public void onKeyReleased(KeyEvent e) {
    }

    /**
     * Called on the update step of the main game loop
     */
    public void update() {
    }

    /**
     * Called on the draw step of the main game loop
     * @param g2D Graphics2D
     */
    public void draw(Graphics2D g2D) {
    }

    /**
     * Intended for the user to implement and use
     */
    public void restart() {
    }

    public void setTargetFPS(int targetFPS) {
        this.targetFPS = targetFPS;
    }

    public int getTargetFPS() {
        return targetFPS;
    }
}
