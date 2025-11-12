
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

        System.out.println("Undo List");
        for (Command c : undoList) {
            System.out.println(c.getDescription());
        }
        System.out.println("-- End of undo list --");

        System.out.println();
        System.out.println("Redo List");
        for (Command c : redoList) {
            System.out.println(c.getDescription());
        }
        System.out.println("-- End of redo list --");
    }

    @Override
    public void undo() {
        // no-op
    }
}
