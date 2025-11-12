/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: SimpleEnsembleFactory.java
 */

public class SimpleEnsembleFactory implements EnsembleFactory {

    @Override
    public Ensemble createEnsemble(String type, String id, String name) {
        if (type == null || id == null || name == null) {
            return null;
        }
        String t = type.trim().toUpperCase();

        Ensemble e;
        if ("O".equals(t)) {
            e = new OrchestraEnsemble(id);
        } else if ("J".equals(t)) {
            e = new JazzBandEnsemble(id);
        } else if ("R".equals(t)) {
            e = new RockBandEnsemble(id);
        } else {
            return null;
        }

        e.setName(name);
        return e;
    }

    @Override
    public Musician createMusician(String id, String name, int role) {
        if (id == null || name == null) {
            return null;
        }
        Musician m = new Musician(id);
        m.setName(name);
        m.setRole(role);
        return m;
    }
}

