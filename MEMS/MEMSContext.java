import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class MEMSContext {

    private Map<String, Ensemble> ensembles = new LinkedHashMap<>();
    private Ensemble current;

    public void addEnsemble(Ensemble ensemble) {
        if (ensemble == null) {
            return;
        }
        ensembles.put(ensemble.getEnsembleID(), ensemble);
    }

    // NEW
    public void removeEnsemble(String id) {
        if (id == null) {
            return;
        }
        Ensemble removed = ensembles.remove(id);
        if (removed != null && removed == current) {
            current = null;
        }
    }

    public Ensemble getEnsemble(String id) {
        if (id == null) {
            return null;
        }
        return ensembles.get(id);
    }

    public boolean setCurrent(String id) {
        Ensemble e = getEnsemble(id);
        if (e == null) {
            return false;
        }
        current = e;
        return true;
    }

    public Ensemble getCurrent() {
        return current;
    }

    public Collection<Ensemble> getAllEnsembles() {
        return ensembles.values();
    }
}

