public class MyClass {
    private int state;

    public MyClass() {
        state = 1; // initial state
    }

    public int getState() {
        return state;
    }

    public void setState(int s) {
        state = s;
    }

    public void doAction() {
        state++;
    }
}

