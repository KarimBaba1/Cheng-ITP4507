
import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public abstract class Ensemble {
    private String ensembleID;
    private String eName;
    private AbstractList<Musician> musicians;

    // Shared scanner for console input
    protected static final Scanner SCANNER = new Scanner(System.in);

    public Ensemble(String eID) {
        this.ensembleID = eID;
        this.musicians = new LinkedList<>();
    }

    public String getEnsembleID() {
        return ensembleID;
    }

    public String getName() {
        return eName;
    }

    public void setName(String name) {
        this.eName = name;
    }

    public void addMusician(Musician m) {
        if (m != null && !musicians.contains(m)) {
            musicians.add(m);
        }
    }

    public void dropMusician(Musician m) {
        if (m != null) {
            musicians.remove(m);
        }
    }

    public Iterator<Musician> getMusicians() {
        return musicians.iterator();
    }

    // Helper for subclasses
    protected Musician findMusicianById(String musicianID) {
        for (Musician m : musicians) {
            if (m.getMID().equalsIgnoreCase(musicianID)) {
                return m;
            }
        }
        return null;
    }

    public abstract void updateMusicianRole();

    public abstract void showEnsemble();
}
