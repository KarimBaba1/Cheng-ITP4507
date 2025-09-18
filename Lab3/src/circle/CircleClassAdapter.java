// CircleClassAdapter.java
import java.awt.Point;

public class CircleClassAdapter extends OldCircleImpl implements NewCircle {

    public CircleClassAdapter(double a, double b, double c) {
        super(a, b, c);
    }

    @Override
    public double getRadius() {
        double[] c = getCoeff();
        return Math.sqrt(c[2]);
    }

    @Override
    public Point getCenter() {
        double[] c = getCoeff();
        return new Point((int) Math.round(c[0]), (int) Math.round(c[1]));
    }
}

