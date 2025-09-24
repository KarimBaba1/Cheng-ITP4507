public class Main {
    public static void main(String[] args) {
        // Case 1: screen
        Debug d1 = new DebugToScreen();
        Cal cal1 = new Cal(d1);
        cal1.compute();

        System.out.println("---- Now check log.txt ----");

        // Case 2: file
        try (DebugToTextFile d2 = new DebugToTextFile()) {
            Cal cal2 = new Cal(d2);
            cal2.compute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

