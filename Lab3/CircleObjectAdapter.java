import java.awt.Point;

public class CircleObjectAdapter implements NewCircle {
    private final OldCircle adaptee;

    public CircleObjectAdapter(OldCircle adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public double getRadius() {
        double[] c = adaptee.getCoeff();
        return Math.sqrt(c[2]); // radius = sqrt(c)
    }

    @Override
    public Point getCenter() {
        double[] c = adaptee.getCoeff();
        // NewCircle requires java.awt.Point (int-based), so cast.
        return new Point((int) Math.round(c[0]), (int) Math.round(c[1]));
    }
}

