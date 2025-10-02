
// ExitCommand.java
public class ExitCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Exiting program...");
        System.exit(0);
    }

    @Override
    public void undo() {
        // Exit cannot be undone
    }
}
