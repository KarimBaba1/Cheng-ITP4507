
public interface EnsembleFactory {

    Ensemble createEnsemble(String type, String id, String name);

    Musician createMusician(String id, String name, int role);
}
