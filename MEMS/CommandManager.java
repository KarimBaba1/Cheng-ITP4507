
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandManager {

    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();

    public void execute(Command c) {
        if (c == null) {
            return;
        }

        c.execute();

        boolean undoable = true;
        if (c instanceof AbstractCommand) {
            undoable = ((AbstractCommand) c).isUndoable();
        }

        if (undoable) {
            undoStack.push(c);
            redoStack.clear();
        }
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        Command c = undoStack.pop();
        c.undo();
        redoStack.push(c);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        Command c = redoStack.pop();
        c.execute();          // re-apply command
        undoStack.push(c);
    }

    public List<Command> getUndoList() {
        return new ArrayList<>(undoStack);
    }

    public List<Command> getRedoList() {
        return new ArrayList<>(redoStack);
    }
}
