
public class DeleteMusicianCommand extends AbstractCommand {

    private final String musicianId;

    private String ensembleId;
    private Musician deletedMusician;

    public DeleteMusicianCommand(MEMSContext ctx,
                                 CommandManager manager,
                                 String musicianId) {
        super(ctx, manager,
              "Delete musician, " + musicianId);
        this.musicianId = musicianId;
    }

    @Override
    public void execute() {
        Ensemble current = ctx.getCurrent();
        if (current == null) {
            System.out.println("No current ensemble selected.");
            return;
        }

        if (ensembleId == null) {
            ensembleId = current.getEnsembleID();
        }

        Ensemble e = ctx.getEnsemble(ensembleId);
        if (e == null) {
            System.out.println("Ensemble not found.");
            return;
        }

        Musician m = e.findMusicianById(musicianId);
        if (m == null) {
            System.out.println("Musician not found.");
            return;
        }

        if (deletedMusician == null) {
            deletedMusician = m;
        }

        e.dropMusician(m);
        System.out.println("Musician is deleted.");
    }

    @Override
    public void undo() {
        if (ensembleId == null || deletedMusician == null) {
            return;
        }

        Ensemble e = ctx.getEnsemble(ensembleId);
        if (e == null) {
            return;
        }

        e.addMusician(deletedMusician);
    }
}
