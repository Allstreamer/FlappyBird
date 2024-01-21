import java.awt.*;

public class PipeSet {
    double x;
    final double y;
    final double spacing = 100.0;
    final double edgeMargin = 100;
    public boolean done = false;

    public PipeSet() {
        y = (Math.random() * (SpielFenster.height - (edgeMargin * 2))) + edgeMargin;
        x = SpielFenster.width;
    }

    public void update(double delta) {
        x -= delta * 50000;

        done = x <= 0;
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.GREEN);
        g2D.drawRect((int) x, (int) y + (int)spacing, 20, SpielFenster.height);
        g2D.drawRect((int) x, (int) y - SpielFenster.height - (int)spacing, 20, SpielFenster.height);
    }
}
