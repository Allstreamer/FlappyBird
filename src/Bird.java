import java.awt.*;

public class Bird {
    final double x = 100.0;
    double y = 0.0;
    double y_vel = 0.0;
    final int radius = 20;
    final double gravity = 9.81;

    public void update(double delta) {
        y_vel += delta * gravity * 1000;
        y += y_vel;
        // Prevent bird from going off-screen
        y = Math.max(0, Math.min(y, SpielFenster.height));
    }

    public void jump() {
        y_vel = -10;
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.WHITE);
        g2D.drawOval((int) x, (int)y, radius, radius);
    }
}
