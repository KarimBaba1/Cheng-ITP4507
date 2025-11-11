import java.util.Scanner;

public class Lab06Q1B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Caretaker ct = new Caretaker();
        MyClass mc = new MyClass();

        System.out.println("Create a my class object with state 1");
        ct.saveMyClass(mc);

        int cmd = -1;
        while (cmd != 0) {
            System.out.print("Enter command: 0 = exit, 1 = undo, 2 = redo, 3 = doAction\n");
            cmd = sc.nextInt();

            switch (cmd) {
                case 1:
                    ct.undo();
                    System.out.println("Current state :" + mc.getState());
                    break;
                case 2:
                    ct.redo();
                    System.out.println("Current state :" + mc.getState());
                    break;
                case 3:
                    mc.doAction();
                    ct.saveMyClass(mc);
                    System.out.println("Current state :" + mc.getState());
                    break;
                case 0:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        sc.close();
    }
}

