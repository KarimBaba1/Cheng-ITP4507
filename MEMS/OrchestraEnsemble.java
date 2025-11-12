public class OrchestraEnsemble extends Ensemble {

    public static final int VIOLINIST_ROLE = 1;
    public static final int CELLIST_ROLE   = 2;

    public OrchestraEnsemble(String eID) {
        super(eID);
    }

    @Override
    public void updateMusicianRole() {
        // unchanged; not used by current command-based UI
        System.out.print("Please input musician ID:- ");
        String id = SCANNER.nextLine().trim();

        Musician m = findMusicianById(id);
        if (m == null) {
            System.out.println("Musician not found.");
            return;
        }

        System.out.print("Instrument (1 = violinist | 2 = cellist ):- ");
        String input = SCANNER.nextLine().trim();
        int newRole;
        try {
            newRole = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid role.");
            return;
        }

        if (newRole != VIOLINIST_ROLE && newRole != CELLIST_ROLE) {
            System.out.println("Invalid role.");
            return;
        }

        m.setRole(newRole);
        System.out.println("Instrument is updated.");
    }

    @Override
    public void showEnsemble() {
        String line = "============================================================";
        System.out.println(line);
        System.out.println("Orchestra Ensemble " + getName() + " (" + getEnsembleID() + ")");
        System.out.println(line);
        System.out.println("Violinist:");
        for (java.util.Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == VIOLINIST_ROLE) {
                System.out.println("  " + m.getMID() + ", " + m.getName());
            }
        }
        System.out.println();
        System.out.println("Cellist:");
        for (java.util.Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == CELLIST_ROLE) {
                System.out.println("  " + m.getMID() + ", " + m.getName());
            }
        }
        System.out.println(line);
    }
}

