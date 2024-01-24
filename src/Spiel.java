import Engine.SpielBackend;
import Engine.SpielFenster;
import Engine.SpielInput;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Spiel extends SpielBackend {
    Bird bird = new Bird();
    PipeSet pipeSet = new PipeSet();

    enum GameState {
        Ready,
        Running,
    }
    GameState currentGameState = GameState.Ready;

    public Spiel() {
        new SpielFenster("Flappy Bird", 800, 800);
    }

    public void update() {
        // Only run game logic when in Running state
        if (currentGameState != GameState.Running) {
            if (SpielInput.isKeyPressed(KeyEvent.VK_SPACE))
                currentGameState = GameState.Running;
            return;
        }

        if (pipeSet.done)
            pipeSet = new PipeSet();

        if (SpielInput.isKeyPressed(KeyEvent.VK_SPACE))
            bird.jump();

        pipeSet.update(delta);
        bird.update(delta, pipeSet);
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.WHITE);
        g2D.drawString(Math.round(1d / delta) + " FPS", 10, 10);
        if (currentGameState != GameState.Running) {
            g2D.setColor(Color.WHITE);
            g2D.drawString("Press Space to Start", SpielFenster.getWidth() /2 - 60, SpielFenster.getHeight() /2);
            return;
        }
        pipeSet.draw(g2D);
        bird.draw(g2D);
    }

    public void restart() {
        currentGameState = GameState.Ready;
        bird = new Bird();
        pipeSet = new PipeSet();
    }
}
