import java.util.Stack;

public class Caretaker {
    private Stack<Memento> undoList;

    public Caretaker() {
        undoList = new Stack<>();
    }

    public void saveMyClass(MyClass mc) {
        Memento m = new Memento(mc);
        undoList.push(m);
    }

    public void undo() {
        if (!undoList.isEmpty()) {
            Memento m = undoList.pop();
            m.restore();
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}

