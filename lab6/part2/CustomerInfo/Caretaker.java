package CustomerInfo;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> undoList;
    private Stack<Memento> redoList;

    public Caretaker() {
        undoList = new Stack<>();
        redoList = new Stack<>();
    }

    public void saveAccount(Account a) {
        undoList.push(new Memento(a));
        redoList.clear();
    }

    public void saveCustomer(Customer c) {
        undoList.push(new Memento(c));
        redoList.clear();
    }

    public void undo() {
        if (!undoList.isEmpty()) {
            Memento m = undoList.pop();
            redoList.push(m);
            m.restore();
            System.out.println("Undo performed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoList.isEmpty()) {
            Memento m = redoList.pop();
            undoList.push(m);
            m.restore();
            System.out.println("Redo performed.");
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}

