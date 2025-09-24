public class DebugToScreen implements Debug {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

