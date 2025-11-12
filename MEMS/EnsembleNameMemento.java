/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: EnsembleNameMemento.java
 */


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
