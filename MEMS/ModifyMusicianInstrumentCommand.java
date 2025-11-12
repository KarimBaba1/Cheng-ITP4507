public class ModifyMusicianInstrumentCommand extends AbstractCommand {

    private final String musicianId;
    private final int requestedNewRole;

    private MusicianRoleMemento memento;   // holds musician ref + old/new roles

    public ModifyMusicianInstrumentCommand(MEMSContext ctx,
                                           CommandManager manager,
                                           String musicianId,
                                           int newRole) {
        super(ctx, manager,
              "Modify musician's instrument, " + musicianId);
        this.musicianId = musicianId;
        this.requestedNewRole = newRole;
    }

    @Override
    public void execute() {
        // First execution: build the memento
        if (memento == null) {
            Ensemble current = ctx.getCurrent();
            if (current == null) {
                System.out.println("No current ensemble selected.");
                return;
            }

            Musician m = current.findMusicianById(musicianId);
            if (m == null) {
                System.out.println("Musician not found.");
                return;
            }

            int oldRole = m.getRole();
            memento = new MusicianRoleMemento(m, oldRole, requestedNewRole);
        }

        // Apply "redo" side of the memento
        Musician target = memento.getMusician();
        target.setRole(memento.getNewRole());
        System.out.println("Instrument is updated.");
    }

    @Override
    public void undo() {
        if (memento == null) {
            return;
        }

        Musician target = memento.getMusician();
        target.setRole(memento.getOldRole());
    }
}

