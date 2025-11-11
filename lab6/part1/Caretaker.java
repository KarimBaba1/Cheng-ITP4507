import java.util.Stack;

class Caretaker {
    private Stack<Memento> undoList;
    private Stack<Memento> redoList;

    public Caretaker() {
        undoList = new Stack<>();
        redoList = new Stack<>();
    }

    public void saveMyClass(MyClass mc) {
        Memento m = new Memento(mc);
        undoList.push(m);
        // Every new save clears redo history
        redoList.clear();
    }

    public void undo() {
        if (!undoList.isEmpty()) {
            Memento m = undoList.pop();
            redoList.push(new Memento(m.myClass));
            m.restore();
            System.out.println("Perform undo.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            Memento m = redoList.pop();
            undoList.push(new Memento(m.myClass));
            m.restore();
            System.out.println("Perform redo.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}

