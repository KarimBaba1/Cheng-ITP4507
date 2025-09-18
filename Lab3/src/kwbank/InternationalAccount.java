// kwbank/InternationalAccount.java
package kwbank;

public class InternationalAccount {
    protected String accountnumber;
    protected double balance;
    protected String currency;
    protected ForeignExchangeCalculator fx; // utilizes

    public InternationalAccount(String accountnumber, double openingBalance, String currency,
                                ForeignExchangeCalculator fx) {
        this.accountnumber = accountnumber;
        this.balance = openingBalance;
        this.currency = currency;
        this.fx = fx;
    }

    public void increase(double amount) { // deposit
        if (amount < 0) throw new IllegalArgumentException("amount < 0");
        balance += amount;
    }

    public void decrease(double amount) { // withdraw
        if (amount < 0) throw new IllegalArgumentException("amount < 0");
        if (amount > balance) throw new IllegalArgumentException("insufficient funds");
        balance -= amount;
    }

    public double showbalance() {
        return balance;
    }

    public double showbalanceInUSD() {
        if ("HKD".equalsIgnoreCase(currency)) {
            return fx.HKD2USD(balance);
        }
        // add other currencies as needed
        return balance; // assume already USD
    }

    public String getAccountnumber() { return accountnumber; }
    public String getCurrency() { return currency; }
}

