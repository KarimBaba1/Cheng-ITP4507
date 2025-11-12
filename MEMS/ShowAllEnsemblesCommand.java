
public class ShowAllEnsemblesCommand extends AbstractCommand {

    public ShowAllEnsemblesCommand(MEMSContext ctx,
                                   CommandManager manager) {
        super(ctx, manager, "Show all ensembles", false);
    }

    @Override
    public void execute() {
        for (Ensemble e : ctx.getAllEnsembles()) {
            if (e instanceof OrchestraEnsemble) {
                System.out.println("Orchestra Ensemble " +
                        e.getName() + " (" + e.getEnsembleID() + ")");
            } else if (e instanceof JazzBandEnsemble) {
                System.out.println("Jazz Band Ensemble " +
                        e.getName() + " (" + e.getEnsembleID() + ")");
            } else {
                System.out.println("Ensemble " +
                        e.getName() + " (" + e.getEnsembleID() + ")");
            }
        }
    }

    @Override
    public void undo() {
        // no-op
    }
}
