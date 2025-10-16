package CustomerInfo;

import java.util.Vector;

public class Memento {
    private Account account;
    private Customer customer;
    private Account accState;
    private Customer custState;

    // Backup for Account
    public Memento(Account a) {
        account = a;
        accState = a.clone();
    }

    // Backup for Customer
    public Memento(Customer c) {
        customer = c;
        custState = c.clone();
    }

    public void restore() {
        if (account != null && accState != null) {
            account = copyAccount(accState, account);
        } else if (customer != null && custState != null) {
            customer.setAddress(custState.getAddress());
            customer.setAccounts((Vector<Account>) custState.getAccounts().clone());
        }
    }

    private Account copyAccount(Account src, Account dest) {
        try {
            java.lang.reflect.Field balanceField = Account.class.getDeclaredField("balance");
            balanceField.setAccessible(true);
            balanceField.setDouble(dest, src.getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dest;
    }
}

