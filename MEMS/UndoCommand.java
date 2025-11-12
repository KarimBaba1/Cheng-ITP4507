
public class UndoCommand extends AbstractCommand {

    public UndoCommand(MEMSContext ctx,
                       CommandManager manager) {
        super(ctx, manager, "Undo", false);
    }

    @Override
    public void execute() {
        manager.undo();
    }

    @Override
    public void undo() {
        // no-op
    }
}
