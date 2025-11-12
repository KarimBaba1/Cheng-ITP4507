/**
 * Musical Ensemble Management System (MEMS)
 * Module: ITP4507
 * Student Name: Karim Baba
 * Student ID: 240167470
 * File: SimpleCommandFactory.java
 */

import java.util.Scanner;

public class SimpleCommandFactory implements CommandFactory {

    private final MEMSContext ctx;
    private final CommandManager manager;
    private final EnsembleFactory ensembleFactory;
    private final Scanner scanner;

    public SimpleCommandFactory(Scanner scanner,
                                MEMSContext ctx,
                                CommandManager manager,
                                EnsembleFactory ensembleFactory) {
        this.scanner = scanner;
        this.ctx = ctx;
        this.manager = manager;
        this.ensembleFactory = ensembleFactory;
    }

    @Override
    public Command createCommand(String userCommand) {
        if (userCommand == null) {
            return null;
        }
        String cmd = userCommand.trim().toLowerCase();

        switch (cmd) {
            case "c":
                return createCreateEnsembleCommand();
            case "s":
                return createSetCurrentEnsembleCommand();
            case "a":
                return createAddMusicianCommand();
            case "m":
                return createModifyMusicianInstrumentCommand();
            case "d":
                return createDeleteMusicianCommand();
            case "se":
                return new ShowCurrentEnsembleCommand(ctx, manager);
            case "sa":
                return new ShowAllEnsemblesCommand(ctx, manager);
            case "cn":
                return createChangeEnsembleNameCommand();
            case "u":
                return new UndoCommand(ctx, manager);
            case "r":
                return new RedoCommand(ctx, manager);
            case "l":
                return new ShowHistoryCommand(ctx, manager);
            default:
                System.out.println("Unknown command: " + userCommand);
                return null;
        }
    }

    // ---------- Helpers for each command that needs extra input ----------

    private Command createCreateEnsembleCommand() {
        System.out.print("Enter music type (o = orchestra | j = jazz band | r = rock band) :- ");
        String typeInput = readLineEcho().trim();
        if (typeInput.isEmpty()) {
            System.out.println("Type is required.");
            return null;
        }
        String type = typeInput.substring(0, 1).toUpperCase();
        if (!type.equals("O") && !type.equals("J") && !type.equals("R")) {
            System.out.println("Invalid music type.");
            return null;
        }

        System.out.print("Ensemble ID:- ");
        String id = readLineEcho().trim();
        if (id.isEmpty()) {
            System.out.println("Ensemble ID is required.");
            return null;
        }

        System.out.print("Ensemble Name:- ");
        String name = readLineEcho().trim();
        if (name.isEmpty()) {
            System.out.println("Ensemble name is required.");
            return null;
        }

        return new CreateEnsembleCommand(ctx, manager, ensembleFactory, type, id, name);
    }

    private Command createSetCurrentEnsembleCommand() {
        System.out.print("Please input ensemble ID:- ");
        String id = readLineEcho().trim();
        if (id.isEmpty()) {
            System.out.println("Ensemble ID is required.");
            return null;
        }
        return new SetCurrentEnsembleCommand(ctx, manager, id);
    }

    private Command createAddMusicianCommand() {
        Ensemble current = ctx.getCurrent();
        if (current == null) {
            System.out.println("No current ensemble selected.");
            return null;
        }

        System.out.print("Please input musician information (id, name):- ");
        String line = readLineEcho();
        String[] parts = line.split(",", 2);
        if (parts.length < 2) {
            System.out.println("Invalid format. Expected: id, name");
            return null;
        }

        String musicianId = parts[0].trim();
        String musicianName = parts[1].trim();
        if (musicianId.isEmpty() || musicianName.isEmpty()) {
            System.out.println("Musician id and name must not be empty.");
            return null;
        }

        int role = readRoleForCurrentEnsemble(current);
        if (!isRoleValidForEnsemble(current, role)) {
            System.out.println("Invalid instrument choice.");
            return null;
        }

        return new AddMusicianCommand(ctx, manager, ensembleFactory,
                                      musicianId, musicianName, role);
    }

    private Command createModifyMusicianInstrumentCommand() {
        Ensemble current = ctx.getCurrent();
        if (current == null) {
            System.out.println("No current ensemble selected.");
            return null;
        }

        System.out.print("Please input musician ID:- ");
        String id = readLineEcho().trim();
        if (id.isEmpty()) {
            System.out.println("Musician ID is required.");
            return null;
        }

        int newRole = readRoleForCurrentEnsemble(current);
        if (!isRoleValidForEnsemble(current, newRole)) {
            System.out.println("Invalid instrument choice.");
            return null;
        }

        return new ModifyMusicianInstrumentCommand(ctx, manager, id, newRole);
    }

    private Command createDeleteMusicianCommand() {
        Ensemble current = ctx.getCurrent();
        if (current == null) {
            System.out.println("No current ensemble selected.");
            return null;
        }

        System.out.print("Please input musician ID:- ");
        String id = readLineEcho().trim();
        if (id.isEmpty()) {
            System.out.println("Musician ID is required.");
            return null;
        }

        return new DeleteMusicianCommand(ctx, manager, id);
    }

    private Command createChangeEnsembleNameCommand() {
        Ensemble current = ctx.getCurrent();
        if (current == null) {
            System.out.println("No current ensemble selected.");
            return null;
        }

        System.out.print("Please input new name of the current ensemble:- ");
        String newName = readLineEcho().trim();
        if (newName.isEmpty()) {
            System.out.println("Name is required.");
            return null;
        }

        return new ChangeEnsembleNameCommand(ctx, manager, newName);
    }

    // ---------- Utility input helpers ----------

    private String readLineEcho() {
        if (!scanner.hasNextLine()) {
            return "";
        }
        String line = scanner.nextLine();
        System.out.println(line);   // echo user input
        return line;
    }

    private int readRoleForCurrentEnsemble(Ensemble current) {
        if (current instanceof OrchestraEnsemble) {
            System.out.print("Instrument (1 = violinist | 2 = cellist ):-  ");
        } else if (current instanceof JazzBandEnsemble) {
            System.out.print("Instrument (1 = pianist | 2 = saxophonist  | 3 = drummer):-  ");
        } else if (current instanceof RockBandEnsemble) {
            System.out.print(
                    "Instrument (1 = guitarist | 2 = bassist | 3 = drummer | 4 = vocalist):-  ");
        } else {
            System.out.print("Instrument code (integer):- ");
        }

        String line = readLineEcho().trim();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean isRoleValidForEnsemble(Ensemble current, int role) {
        if (role <= 0) {
            return false;
        }

        if (current instanceof OrchestraEnsemble) {
            return role == OrchestraEnsemble.VIOLINIST_ROLE
                    || role == OrchestraEnsemble.CELLIST_ROLE;
        }
        if (current instanceof JazzBandEnsemble) {
            return role == JazzBandEnsemble.PIANIST_ROLE
                    || role == JazzBandEnsemble.SAXOPHONIST_ROLE
                    || role == JazzBandEnsemble.DRUMMER_ROLE;
        }
        if (current instanceof RockBandEnsemble) {
            return role == RockBandEnsemble.GUITARIST_ROLE
                    || role == RockBandEnsemble.BASSIST_ROLE
                    || role == RockBandEnsemble.DRUMMER_ROLE
                    || role == RockBandEnsemble.VOCALIST_ROLE;
        }
        // default: accept any positive role
        return true;
    }
}

