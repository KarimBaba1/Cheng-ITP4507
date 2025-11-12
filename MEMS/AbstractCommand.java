
public abstract class AbstractCommand implements Command {

    protected final MEMSContext ctx;
    protected final CommandManager manager;
    private final String description;
    private final boolean undoable;

    protected AbstractCommand(MEMSContext ctx,
                              CommandManager manager,
                              String description) {
        this(ctx, manager, description, true);
    }

    // For commands that should NOT appear in undo/redo (e.g. pure display)
    protected AbstractCommand(MEMSContext ctx,
                              CommandManager manager,
                              String description,
                              boolean undoable) {
        this.ctx = ctx;
        this.manager = manager;
        this.description = description;
        this.undoable = undoable;
    }

    @Override
    public String getDescription() {
        return description;
    }

    // default: do nothing; state-changing commands override
    @Override
    public void undo() {
        // no-op by default
    }

    // used by CommandManager to decide whether to push to undo stack
    public boolean isUndoable() {
        return undoable;
    }
}
