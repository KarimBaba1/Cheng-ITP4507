import CustomerInfo.*;

public class Main {
  public static void main(String args[]) {
    Customer peter = new Customer("Peter", "Wanchai");
    Account a1 = new Account("INT001", 100);
    Account a2 = new Account("INT002", 200);
    peter.addAccount(a1);
    peter.addAccount(a2);

    Caretaker ct = new Caretaker();
    peter.showInfo();

    ct.saveAccount(peter.getAccount(0));
    peter.getAccount(0).increase(50);
    ct.saveAccount(peter.getAccount(1));
    peter.getAccount(1).decrease(20);
    peter.showInfo();

    ct.saveCustomer(peter);
    peter.setAddress("Wong Tai Sin");
    peter.showInfo();

    ct.saveCustomer(peter);
    peter.removeAccount(peter.getAccount(1));
    peter.showInfo();

    ct.undo();
    peter.showInfo();

    ct.undo();
    peter.showInfo();

    ct.undo();
    peter.showInfo();

    ct.undo();
    peter.showInfo();

    ct.redo();
    peter.showInfo();

    ct.redo();
    peter.showInfo();

    ct.redo();
    peter.showInfo();

    ct.redo();
    peter.showInfo();
  }
}

