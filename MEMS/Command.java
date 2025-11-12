/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: Command.java
 */


public interface Command {
    void execute();
    void undo();
    String getDescription();
}
