package CustomerInfo;

public class Account implements Cloneable {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void increase(double amount) {
        balance += amount;
    }

    public void decrease(double amount) {
        balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public Account clone() {
        try {
            return (Account) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void showInfo() {
        System.out.println("Account No: " + accountNumber + ", Balance: " + balance);
    }
}

