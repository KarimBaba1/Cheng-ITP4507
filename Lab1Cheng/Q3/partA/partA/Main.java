public class Main {
  public static void main(String[] args) {
    // OPTION A: log to console
    // Cal cal = new Cal();
    // cal.compute();

    // OPTION B: log to file (log.txt)
    try (Cal2 cal = new Cal2()) {   // auto-closes file writer
      cal.compute();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

