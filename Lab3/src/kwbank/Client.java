// kwbank/Client.java
package kwbank;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String address;
    private final List<InternationalAccount> accounts = new ArrayList<>();

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setname(String name) { this.name = name; }
    public String getname() { return name; }
    public void setaddress(String address) { this.address = address; }
    public String getaddress() { return address; }

    public void addAccount(InternationalAccount a) { accounts.add(a); }
    public List<InternationalAccount> getAccounts() { return accounts; }
}

