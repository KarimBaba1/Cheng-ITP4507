// TestCircleAdapter.java
public class TestCircleAdapter {
    public static void main(String[] args) {
        // ---- Part A: Object adapter ----
        OldCircle oldCircle = new OldCircleImpl(10.0, 15.0, 25.5);
        NewCircle adaptedA = new CircleObjectAdapter(oldCircle);
        System.out.println("[Part A: Object Adapter]");
        PrintCircle.printCircle(adaptedA);

        // ---- Part B: Class adapter ----
        NewCircle adaptedB = new CircleClassAdapter(10.0, 15.0, 25.5);
        System.out.println("\n[Part B: Class Adapter]");
        PrintCircle.printCircle(adaptedB);
    }
}

