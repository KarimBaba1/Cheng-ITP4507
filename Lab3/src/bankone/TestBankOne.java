// bankone/TestBankOne.java
package bankone;

public class TestBankOne {
    public static void main(String[] args) {
        Customer c = new Customer("Alice", "Central");
        Account s = new SavingAccount("S-1001", 1000.0);
        Account l = new LoanAccount("L-2001", 5000.0);

        c.addAccount(s);
        c.addAccount(l);

        s.credit(250.0);           // deposit
        s.debit(100.0);            // withdraw
        l.debit(500.0);            // repay part of loan

        System.out.println("Customer: " + c.getName());
        for (Account a : c.getAccounts()) {
            System.out.printf("  %s balance: %.2f%n", a.getAccountNumber(), a.getBalance());
        }
    }
}

