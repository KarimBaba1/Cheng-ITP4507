
public class SimpleEnsembleFactory implements EnsembleFactory {

    @Override
    public Ensemble createEnsemble(String type, String id, String name) {
        if (type == null) {
            throw new IllegalArgumentException("Ensemble type cannot be null");
        }

        String t = type.trim().toUpperCase();
        Ensemble ensemble;

        switch (t) {
            case "O":
                ensemble = new OrchestraEnsemble(id);
                break;
            case "J":
                ensemble = new JazzBandEnsemble(id);
                break;
            default:
                throw new IllegalArgumentException("Unsupported ensemble type: " + type);
        }

        ensemble.setName(name);
        return ensemble;
    }

    @Override
    public Musician createMusician(String id, String name, int role) {
        Musician m = new Musician(id);
        m.setName(name);
        m.setRole(role);
        return m;
    }
}
