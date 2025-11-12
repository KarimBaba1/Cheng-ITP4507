/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: MusicianRoleMemento.java
 */


public class MusicianRoleMemento {

    private final Musician musician;
    private final int oldRole;
    private final int newRole;

    public MusicianRoleMemento(Musician musician, int oldRole, int newRole) {
        this.musician = musician;
        this.oldRole = oldRole;
        this.newRole = newRole;
    }

    public Musician getMusician() {
        return musician;
    }

    public int getOldRole() {
        return oldRole;
    }

    public int getNewRole() {
        return newRole;
    }
}
