import java.util.Scanner;

public class Main {

    // ASCII box width: 60 chars
    private static final String BORDER = "+----------------------------------------------------------+";

    public static void main(String[] args) {
        MEMSContext ctx = new MEMSContext();
        CommandManager manager = new CommandManager();
        EnsembleFactory ensembleFactory = new SimpleEnsembleFactory();
        Scanner scanner = new Scanner(System.in);
        CommandFactory commandFactory =
                new SimpleCommandFactory(ctx, manager, ensembleFactory, scanner);

        boolean running = true;

        while (running) {
            printMenu(ctx);
            System.out.print("Please enter command [ c | s | a | m | d | se | sa | cn | u | r | l | x ] :- ");
            String line = scanner.nextLine();
            if (line == null) {
                continue;
            }
            String cmdCode = line.trim().toLowerCase();
            if (cmdCode.equals("x")) {
                running = false;
                break;
            }

            Command cmd = commandFactory.createCommand(cmdCode);
            if (cmd != null) {
                manager.execute(cmd);
            }

            System.out.println();
            System.out.println(BORDER);
            System.out.println();
        }

        System.out.println("System exited.");
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

