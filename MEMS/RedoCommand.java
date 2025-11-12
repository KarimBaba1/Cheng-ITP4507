
public class RedoCommand extends AbstractCommand {

    public RedoCommand(MEMSContext ctx,
                       CommandManager manager) {
        super(ctx, manager, "Redo", false);
    }

    @Override
    public void execute() {
        manager.redo();
    }

    @Override
    public void undo() {
        // no-op
    }
}
