
public class CreateEnsembleCommand extends AbstractCommand {

    private final EnsembleFactory factory;
    private final String type;
    private final String id;
    private final String name;

    private String previousCurrentId;
    private Ensemble createdEnsemble;

    public CreateEnsembleCommand(MEMSContext ctx,
                                 CommandManager manager,
                                 EnsembleFactory factory,
                                 String type,
                                 String id,
                                 String name) {
        super(ctx, manager, buildDescription(type, id, name));
        this.factory = factory;
        this.type = type;
        this.id = id;
        this.name = name;
    }

    private static String buildDescription(String type, String id, String name) {
        return "Create ensemble, " + id + ", " + name;
    }

    @Override
    public void execute() {
        // first-time execution
        if (createdEnsemble == null) {
            Ensemble current = ctx.getCurrent();
            if (current != null) {
                previousCurrentId = current.getEnsembleID();
            }
            createdEnsemble = factory.createEnsemble(type, id, name);
        }

        ctx.addEnsemble(createdEnsemble);
        ctx.setCurrent(id);

        if ("O".equalsIgnoreCase(type)) {
            System.out.println("Orchestra ensemble is created.");
        } else if ("J".equalsIgnoreCase(type)) {
            System.out.println("Jazz band ensemble is created.");
        } else {
            System.out.println("Ensemble is created.");
        }
        System.out.println("Current ensemble is changed to " + id + ".");
    }

    @Override
    public void undo() {
        ctx.removeEnsemble(id);
        if (previousCurrentId != null) {
            ctx.setCurrent(previousCurrentId);
        }
    }
}
