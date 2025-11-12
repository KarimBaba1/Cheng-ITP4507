/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: AddMusicianCommand.java
 */


public class AddMusicianCommand extends AbstractCommand {

    private final EnsembleFactory factory;
    private final String musicianId;
    private final String musicianName;
    private final int role;

    private String ensembleId;      // ensemble where the add occurred
    private Musician musician;      // same instance for redo

    public AddMusicianCommand(MEMSContext ctx,
                              CommandManager manager,
                              EnsembleFactory factory,
                              String musicianId,
                              String musicianName,
                              int role) {
        super(ctx, manager,
              "Add musician, " + musicianId + ", " + musicianName);
        this.factory = factory;
        this.musicianId = musicianId;
        this.musicianName = musicianName;
        this.role = role;
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

        // First run: create musician
        if (musician == null) {
            musician = factory.createMusician(musicianId, musicianName, role);
        }

        current.addMusician(musician);
        System.out.println("Musician is added.");
    }

    @Override
    public void undo() {
        if (ensembleId == null || musician == null) {
            return;
        }

        Ensemble e = ctx.getEnsemble(ensembleId);
        if (e == null) {
            return;
        }

        e.dropMusician(musician);
    }
}
