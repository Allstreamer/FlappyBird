import java.awt.*;
import java.awt.event.KeyEvent;

public class Spiel extends SpielBackend {
    Bird bird = new Bird();
    PipeSet pipeSet;

    public Spiel() {
        super(); // Nicht vergessen!
        SpielFenster spielFenster = new SpielFenster("Flappy Bird", 800, 800);
    }

    public void update() {
        if (pipeSet == null)
            pipeSet = new PipeSet();
        if (pipeSet.done)
            pipeSet = new PipeSet();

        if (SpielInput.isKeyPressed(KeyEvent.VK_SPACE))
            bird.jump();

        bird.update(delta);
        pipeSet.update(delta);
    }

    public void draw(Graphics2D g2D) {
        bird.draw(g2D);
        pipeSet.draw(g2D);
    }
}
