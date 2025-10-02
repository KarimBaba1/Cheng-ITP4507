// Main.java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Command> history = new Stack<>();

        while (true) {
            System.out.println("Enter command: 0 = exit, 1 = undo, 2 = Command1, 3 = Command2");
            int choice = sc.nextInt();

            Command com = CommandFactory.createCommand(choice, sc, history);
            if (com != null) {
                if (choice == 1) {
                    // Undo doesn't get pushed
                    com.execute();
                } else if (choice == 0) {
                    com.execute(); // Exit program
                } else {
                    com.execute();
                    history.push(com);
                }
            }
        }
    }
}

