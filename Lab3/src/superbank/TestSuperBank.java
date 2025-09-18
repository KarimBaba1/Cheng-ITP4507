// superbank/TestSuperBank.java
package superbank;

import bankone.Customer;
import bankone.SavingAccount;
import bankone.LoanAccount;
import kwbank.Client;
import kwbank.ForeignExchangeCalculator;
import kwbank.InternationalAccount;

public class TestSuperBank {
    public static void main(String[] args) {
        // BankOne data
        Customer alice = new Customer("Alice", "Central");
        SavingAccount sa = new SavingAccount("S-1001", 1000.0);
        LoanAccount la = new LoanAccount("L-2001", 5000.0);
        alice.addAccount(sa);
        alice.addAccount(la);

        // KWBank-side app code still thinks in terms of InternationalAccount:
        ForeignExchangeCalculator fx = new ForeignExchangeCalculator();
        Client kwClientView = new Client(alice.getName(), alice.getAddress());

        // Wrap BankOne accounts as InternationalAccount via adapter:
        InternationalAccount iaSavings = new BankOneAccountAdapter(sa, "HKD", fx);
        InternationalAccount iaLoan    = new BankOneAccountAdapter(la, "HKD", fx);

        kwClientView.addAccount(iaSavings);
        kwClientView.addAccount(iaLoan);

        // All calls use KWBank API, but mutate/read BankOne data underneath
        iaSavings.increase(500.0);           // credit BankOne saving
        iaSavings.decrease(200.0);           // debit BankOne saving
        iaLoan.decrease(1000.0);             // repay part of loan

        System.out.println("SuperBank (KWBank API over BankOne data)");
        for (InternationalAccount ia : kwClientView.getAccounts()) {
            System.out.printf("  %s balance: %.2f HKD (%.2f USD)%n",
                    ia.getAccountnumber(), ia.showbalance(), ia.showbalanceInUSD());
        }
    }
}

