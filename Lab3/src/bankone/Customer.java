// bankone/Customer.java
package bankone;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String address;
    private final List<Account> accounts = new ArrayList<>();

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
}

