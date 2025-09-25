import Shapes.Circle;
import Shapes.Point;
import Shapes.Shape;

public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle(5, new Point(0, 0));
    }
}

