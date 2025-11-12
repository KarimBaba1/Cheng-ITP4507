/**
 * Musical Ensemble Management System (MEMS)
 * Module:ITP4507
 * Student Name:Karim Baba
 * Student ID: 240167470
 * File: CommandFactory.java
 */


public interface CommandFactory {

    /**
     * Create a Command object for the given user command code.
     * Example codes: "c", "s", "a", "m", "d", "se", "sa", "cn", "u", "r", "l", "x".
     */
    Command createCommand(String userCommand);
}
