import Engine.Math.Vec2;
import Engine.SpielFenster;

import java.awt.*;

public class Bird {
    Vec2<Double> pos = new Vec2<Double>(100d, 0d);
    double y_vel = 0.0;
    final int radius = 20;
    final double gravity = 9.81;

    public void update(double delta, PipeSet pipeSet) {
        y_vel += delta * gravity * 5;
        pos.y += y_vel;
        // Prevent bird from going off-screen
        pos.y = Math.max(0, Math.min(pos.y, SpielFenster.getHeight()));

        // Check if within X bounds
        if (pos.x + radius > pipeSet.pos.x && pos.x < pipeSet.pos.x + pipeSet.width) {
            if (!(pos.y+radius > pipeSet.pos.y - pipeSet.spacing && pos.y < pipeSet.pos.y + pipeSet.spacing)) {
                Spiel.instance.restart();
            }
        }

        if (pos.y >= SpielFenster.getHeight()) {
            Spiel.instance.restart();
        }
    }

    public void jump() {
        y_vel = -10;
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.WHITE);
        g2D.drawOval(pos.x.intValue(), pos.y.intValue(), radius, radius);
    }
}
