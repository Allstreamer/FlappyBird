package Engine.Math;

public class Vec2<T extends Number> {
    public T x;
    public T y;

    public Vec2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public Vec2(T value) {
        this.x = value;
        this.y = value;
    }

    public Vec2(Vec2<T> other) {
        this.x = other.x;
        this.y = other.y;
    }

    public void add(Vec2<T> other) {
        this.x = GenericHelpers.add(this.x, other.x);
        this.y = GenericHelpers.add(this.y, other.y);
    }
    public void subtract(Vec2<T> other) {
        this.x = GenericHelpers.subtract(this.x, other.x);
        this.y = GenericHelpers.subtract(this.y, other.y);
    }
    public void multiply(Vec2<T> other) {
        this.x = GenericHelpers.multiply(this.x, other.x);
        this.y = GenericHelpers.multiply(this.y, other.y);
    }
    public void divide(Vec2<T> other) {
        this.x = GenericHelpers.divide(this.x, other.x);
        this.y = GenericHelpers.divide(this.y, other.y);
    }
    public void modulo(Vec2<T> other) {
        this.x = GenericHelpers.modulo(this.x, other.x);
        this.y = GenericHelpers.modulo(this.y, other.y);
    }
    public void normalize() {
        double length = this.magnitude();
        this.x = (T) GenericHelpers.divide(x, length);
        this.y = (T) GenericHelpers.divide(y, length);
    }
    public double magnitude() {
        return GenericHelpers.sqrt(GenericHelpers.add(GenericHelpers.multiply(this.x, this.x), GenericHelpers.multiply(this.y, this.y)));
    }
}
