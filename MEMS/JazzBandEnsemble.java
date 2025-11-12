
public class JazzBandEnsemble extends Ensemble {

    public static final int PIANIST_ROLE      = 1;
    public static final int SAXOPHONIST_ROLE  = 2;
    public static final int DRUMMER_ROLE      = 3;

    public JazzBandEnsemble(String eID) {
        super(eID);
    }

    @Override
    public void updateMusicianRole() {
        System.out.print("Please input musician ID:- ");
        String id = SCANNER.nextLine().trim();

        Musician m = findMusicianById(id);
        if (m == null) {
            System.out.println("Musician not found.");
            return;
        }

        System.out.print("Instrument (1 = pianist | 2 = saxophonist  | 3 = drummer):- ");
        String input = SCANNER.nextLine().trim();
        int newRole;
        try {
            newRole = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid role.");
            return;
        }

        if (newRole != PIANIST_ROLE && newRole != SAXOPHONIST_ROLE && newRole != DRUMMER_ROLE) {
            System.out.println("Invalid role.");
            return;
        }

        m.setRole(newRole);
        System.out.println("Instrument is updated.");
    }

    @Override
    public void showEnsemble() {
        System.out.println("Jazz Band Ensemble " + getName() + " (" + getEnsembleID() + ")");
        System.out.println("Pianist:");
        for (java.util.Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == PIANIST_ROLE) {
                System.out.println(m.getMID() + ", " + m.getName());
            }
        }
        System.out.println("Saxophonist:");
        for (java.util.Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == SAXOPHONIST_ROLE) {
                System.out.println(m.getMID() + ", " + m.getName());
            }
        }
        System.out.println("Drummer:");
        for (java.util.Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == DRUMMER_ROLE) {
                System.out.println(m.getMID() + ", " + m.getName());
            }
        }
    }
}
