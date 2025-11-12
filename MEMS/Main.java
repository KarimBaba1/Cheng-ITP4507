/**
 * Musical Ensemble Management System (MEMS)
 * Module: ITP4507
 * Student Name: Karim Baba
 * Student ID: 240167470
 * File: Main.java
 */

import java.util.Scanner;

public class Main {

    // ASCII box width: 60 chars
    private static final String BORDER =
            "+----------------------------------------------------------+";

    private static String readLineEcho(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            return "";
        }
        String line = scanner.nextLine();
        System.out.println(line);   // echo user input
        return line;
    }

    public static void main(String[] args) {
        MEMSContext ctx = new MEMSContext();
        CommandManager manager = new CommandManager();
        EnsembleFactory ensembleFactory = new SimpleEnsembleFactory();
        Scanner scanner = new Scanner(System.in);
        CommandFactory commandFactory =
                new SimpleCommandFactory(scanner, ctx, manager, ensembleFactory);

        boolean running = true;

        while (running) {
            printMenu(ctx);
            System.out.print(
                    "Please enter command [ c | s | a | m | d | se | sa | cn | u | r | l | x ] :- ");
            String line = readLineEcho(scanner);
            String cmdCode = line.trim().toLowerCase();

            if (cmdCode.equals("x")) {
                running = false;
                break;
            }

            if (cmdCode.isEmpty()) {
                System.out.println("No command entered.");
                System.out.println();
                continue;
            }

            Command cmd = commandFactory.createCommand(cmdCode);
            if (cmd != null) {
                manager.execute(cmd);
            }

            System.out.println(); // blank line between cycles
        }

        System.out.println("System exited.");
        scanner.close();
    }

    private static void printMenu(MEMSContext ctx) {
        System.out.println(BORDER);
        System.out.printf("| %-58s |%n", "Music Ensembles Management System (MEMS)");
        System.out.println(BORDER);
        System.out.printf("| %-58s |%n", "c  = create ensemble");
        System.out.printf("| %-58s |%n", "s  = set current ensemble");
        System.out.printf("| %-58s |%n", "a  = add musician");
        System.out.printf("| %-58s |%n", "m  = modify musician's instrument");
        System.out.printf("| %-58s |%n", "d  = delete musician");
        System.out.printf("| %-58s |%n", "se = show current ensemble");
        System.out.printf("| %-58s |%n", "sa = display all ensembles");
        System.out.printf("| %-58s |%n", "cn = change ensemble's name");
        System.out.printf("| %-58s |%n", "u  = undo");
        System.out.printf("| %-58s |%n", "r  = redo");
        System.out.printf("| %-58s |%n", "l  = list undo/redo");
        System.out.printf("| %-58s |%n", "x  = exit system");
        System.out.println(BORDER);

        String status;
        Ensemble current = ctx.getCurrent();
        if (current != null) {
            status = "Current ensemble: " + current.getEnsembleID()
                    + " " + current.getName();
        } else {
            status = "Current ensemble: (none)";
        }
        System.out.printf("| %-58s |%n", status);
        System.out.println(BORDER);
    }
}

