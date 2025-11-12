
public class EnsembleNameMemento {

    private final Ensemble ensemble;
    private final String oldName;
    private final String newName;

    public EnsembleNameMemento(Ensemble ensemble, String oldName, String newName) {
        this.ensemble = ensemble;
        this.oldName = oldName;
        this.newName = newName;
    }

    public Ensemble getEnsemble() {
        return ensemble;
    }

    public String getOldName() {
        return oldName;
    }

    public String getNewName() {
        return newName;
    }
}
