import java.util.List;

public class ShowHistoryCommand extends AbstractCommand {

    public ShowHistoryCommand(MEMSContext ctx,
                              CommandManager manager) {
        super(ctx, manager, "Show undo/redo list", false);
    }

    @Override
    public void execute() {
        List<Command> undoList = manager.getUndoList();
        List<Command> redoList = manager.getRedoList();

        String line = "============================================================";
        System.out.println(line);
        System.out.println("Undo List");
        System.out.println(line);
        if (undoList.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (Command c : undoList) {
                System.out.println(c.getDescription());
            }
        }
        System.out.println("-- End of undo list --");
        System.out.println();
        System.out.println(line);
        System.out.println("Redo List");
        System.out.println(line);
        if (redoList.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (Command c : redoList) {
                System.out.println(c.getDescription());
            }
        }
        System.out.println("-- End of redo list --");
        System.out.println(line);
    }

    @Override
    public void undo() {
        // no-op
    }
}

