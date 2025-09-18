// bankone/LoanAccount.java
package bankone;

public class LoanAccount extends Account {
    public LoanAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }
    // simple rule: loan debit = repay, credit = borrow more
}

