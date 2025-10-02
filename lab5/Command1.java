import java.util.Scanner;

public class Command1 implements Command {
    private int id;
    private Scanner sc;

    public Command1(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public void execute() {
        System.out.print("Input ID for Command1: ");
        id = sc.nextInt();
        System.out.println(id + " Command1: execute()");
    }

    @Override
    public void undo() {
        System.out.println(id + " Command1: undo()");
    }
}

