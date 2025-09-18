// kwbank/TestKWBank.java
package kwbank;

public class TestKWBank {
    public static void main(String[] args) {
        ForeignExchangeCalculator fx = new ForeignExchangeCalculator();
        Client k = new Client("Bob", "TST");

        InternationalAccount ia = new InternationalAccount("I-3001", 2000.0, "HKD", fx);
        k.addAccount(ia);

        ia.increase(500.0);
        ia.decrease(300.0);

        System.out.println("Client: " + k.getname());
        System.out.printf("  %s balance: %.2f %s (%.2f USD)%n",
                ia.getAccountnumber(), ia.showbalance(), ia.getCurrency(), ia.showbalanceInUSD());
    }
}

