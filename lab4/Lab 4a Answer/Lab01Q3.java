import Shapes.*;
import java.util.*;

/**
 * Lab4a Solution (using Abstract Factory for Shapes only)
 */
public class Lab01Q3 {

  public static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Vector shapes = new Vector();

    int command;
    while (true) {
      System.out.println("Enter command: 0 = exit, 1 = draw all shapes, 2 = create circle, 3 = create rectangle");
      command = sc.nextInt();

      if (command == 0) {
        return;

      } else if (command == 1) {
        for (int i = 0; i < shapes.size(); i++) {
          Client.doAction((Shape) shapes.elementAt(i));
        }

      } else if (command == 2) {
          // directly create a Point
          System.out.println("Enter top-left X:");
          int x = sc.nextInt();
          System.out.println("Enter top-left Y:");
          int y = sc.nextInt();
          Point p = new Point(x, y);

          System.out.println("Enter radius:");
          int r = sc.nextInt();

          Shape s = new Circle(r, p);
          shapes.add(s);          

      } else if (command == 3) {
          // directly create a Point
          System.out.println("Enter top-left X:");
          int x = sc.nextInt();
          System.out.println("Enter top-left Y:");
          int y = sc.nextInt();
          Point p = new Point(x, y);

          System.out.println("Enter width:");
          int width = sc.nextInt();
          System.out.println("Enter height:");
          int height = sc.nextInt();

          Shape s = new Rectangle(width, height, p);
          shapes.add(s);
      }
    }
  } 
}

