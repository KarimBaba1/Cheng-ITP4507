public class SetCurrentEnsembleCommand extends AbstractCommand {

    private final String targetId;

    public SetCurrentEnsembleCommand(MEMSContext ctx,
                                     CommandManager manager,
                                     String targetId) {
        super(ctx, manager,
              "Set current ensemble to " + targetId,
              false); // not undoable
        this.targetId = targetId;
    }

    @Override
    public void execute() {
        boolean ok = ctx.setCurrent(targetId);
        if (!ok) {
            System.out.println("Ensemble " + targetId + " not found.");
            return;
        }
        System.out.println("Changed current ensemble to " + targetId + ".");
    }

    @Override
    public void undo() {
        // no-op, not in undo stack
    }
}

