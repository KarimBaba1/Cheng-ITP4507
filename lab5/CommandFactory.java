// CommandFactory.java
import java.util.Scanner;
import java.util.Stack;

public class CommandFactory {
    public static Command createCommand(int choice, Scanner sc, Stack<Command> history) {
        switch (choice) {
            case 0: return new ExitCommand();
            case 1: return new UndoCommand(history);
            case 2: return new Command1(sc);
            case 3: return new Command2(sc);
            default: 
                System.out.println("Invalid choice.");
                return null;
        }
    }
}

