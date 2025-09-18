// superbank/BankOneAccountAdapter.java
package superbank;

import bankone.Account;
import kwbank.ForeignExchangeCalculator;
import kwbank.InternationalAccount;

public class BankOneAccountAdapter extends InternationalAccount {
    private final Account adaptee;

    public BankOneAccountAdapter(Account adaptee, String currency, ForeignExchangeCalculator fx) {
        // super keeps an API-compatible shape; we ignore super.balance and use adaptee
        super(adaptee.getAccountNumber(), adaptee.getBalance(), currency, fx);
        this.adaptee = adaptee;
    }

    @Override
    public void increase(double amount) {
        adaptee.credit(amount); // deposit to BankOne
    }

    @Override
    public void decrease(double amount) {
        adaptee.debit(amount);  // withdraw/repay in BankOne
    }

    @Override
    public double showbalance() {
        return adaptee.getBalance();
    }

    @Override
    public double showbalanceInUSD() {
        if ("HKD".equalsIgnoreCase(getCurrency())) {
            return fx.HKD2USD(adaptee.getBalance());
        }
        return adaptee.getBalance();
    }
}

