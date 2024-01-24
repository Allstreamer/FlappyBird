import Engine.Math.Vec2;
import Engine.SpielFenster;

import java.awt.*;

public class PipeSet {
    Vec2<Double> pos = new Vec2<Double>(0d, 0d);
    final double spacing = 100.0;
    final double edgeMargin = 100;
    final int width = 20;
    public boolean done = false;

    public PipeSet() {
        pos.y = (Math.random() * (SpielFenster.getHeight() - (edgeMargin * 2))) + edgeMargin;
        pos.x = (double) SpielFenster.getHeight();
    }

    public void update(double delta) {
        pos.x -= delta * 500;

        done = pos.x <= 0;
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.GREEN);
        g2D.drawRect(pos.x.intValue(), pos.y.intValue() + (int)spacing, width, SpielFenster.getHeight());
        g2D.drawRect(pos.x.intValue(), pos.y.intValue() - SpielFenster.getHeight() - (int)spacing, width, SpielFenster.getHeight());
        g2D.drawOval( pos.x.intValue(), pos.y.intValue() ,5, 5);
    }
}
