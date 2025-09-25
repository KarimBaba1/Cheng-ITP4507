import Shapes.Rectangle;
import Shapes.Point;
import Shapes.Shape;

public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle(10, 5, new Point(0, 0));
    }
}

