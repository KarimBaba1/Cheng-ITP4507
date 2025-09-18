// bankone/Account.java
package bankone;

public abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public void debit(double amount) { // withdraw
        if (amount < 0) throw new IllegalArgumentException("amount < 0");
        if (amount > balance) throw new IllegalArgumentException("insufficient funds");
        balance -= amount;
    }

    public void credit(double amount) { // deposit
        if (amount < 0) throw new IllegalArgumentException("amount < 0");
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

