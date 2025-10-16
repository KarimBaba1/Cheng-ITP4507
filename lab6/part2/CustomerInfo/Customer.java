package CustomerInfo;

import java.util.Vector;

public class Customer implements Cloneable {
    private String name;
    private String address;
    private Vector<Account> accounts = new Vector<>();

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public void removeAccount(Account a) {
        accounts.remove(a);
    }

    public Account getAccount(int i) {
        return accounts.get(i);
    }

    public Vector<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Vector<Account> accs) {
        this.accounts = accs;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public Customer clone() {
        try {
            Customer c = (Customer) super.clone();
            c.accounts = (Vector<Account>) accounts.clone();
            return c;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public void showInfo() {
        System.out.println("Customer: " + name + " (" + address + ")");
        for (Account a : accounts) {
            a.showInfo();
        }
        System.out.println("-------------------------");
    }
}

