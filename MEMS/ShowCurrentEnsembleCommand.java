
public class ShowCurrentEnsembleCommand extends AbstractCommand {

    public ShowCurrentEnsembleCommand(MEMSContext ctx,
                                      CommandManager manager) {
        super(ctx, manager, "Show current ensemble", false);
    }

    @Override
    public void execute() {
        Ensemble current = ctx.getCurrent();
        if (current == null) {
            System.out.println("No current ensemble selected.");
            return;
        }
        current.showEnsemble();
    }

    @Override
    public void undo() {
        // no-op
    }
}
