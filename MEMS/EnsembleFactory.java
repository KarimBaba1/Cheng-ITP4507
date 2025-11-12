/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: EnsembleFactory.java
 */


public interface EnsembleFactory {

    Ensemble createEnsemble(String type, String id, String name);

    Musician createMusician(String id, String name, int role);
}
