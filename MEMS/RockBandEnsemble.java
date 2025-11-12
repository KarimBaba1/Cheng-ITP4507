/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: RockBandEnsemble.java
 */


import java.util.Iterator;

public class RockBandEnsemble extends Ensemble {

    public static final int GUITARIST_ROLE = 1;
    public static final int BASSIST_ROLE   = 2;
    public static final int DRUMMER_ROLE   = 3;
    public static final int VOCALIST_ROLE  = 4;

    public RockBandEnsemble(String eID) {
        super(eID);
    }

    @Override
    public void updateMusicianRole() {
        // Only needed to satisfy the original spec; not used by command UI
        System.out.print("Please input musician ID:- ");
        String id = SCANNER.nextLine().trim();

        Musician m = findMusicianById(id);
        if (m == null) {
            System.out.println("Musician not found.");
            return;
        }

        System.out.print("Instrument (1 = guitarist | 2 = bassist | 3 = drummer | 4 = vocalist):- ");
        String input = SCANNER.nextLine().trim();
        int newRole;
        try {
            newRole = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid role.");
            return;
        }

        if (newRole != GUITARIST_ROLE &&
            newRole != BASSIST_ROLE &&
            newRole != DRUMMER_ROLE &&
            newRole != VOCALIST_ROLE) {
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
        System.out.println("Rock Band Ensemble " + getName() + " (" + getEnsembleID() + ")");
        System.out.println(line);

        System.out.println("Guitarist:");
        for (Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == GUITARIST_ROLE) {
                System.out.println("  " + m.getMID() + ", " + m.getName());
            }
        }
        System.out.println();

        System.out.println("Bassist:");
        for (Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == BASSIST_ROLE) {
                System.out.println("  " + m.getMID() + ", " + m.getName());
            }
        }
        System.out.println();

        System.out.println("Drummer:");
        for (Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == DRUMMER_ROLE) {
                System.out.println("  " + m.getMID() + ", " + m.getName());
            }
        }
        System.out.println();

        System.out.println("Vocalist:");
        for (Iterator<Musician> it = getMusicians(); it.hasNext(); ) {
            Musician m = it.next();
            if (m.getRole() == VOCALIST_ROLE) {
                System.out.println("  " + m.getMID() + ", " + m.getName());
            }
        }
        System.out.println(line);
    }
}
