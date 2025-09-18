// kwbank/ForeignExchangeCalculator.java
package kwbank;

public class ForeignExchangeCalculator {
    // For demo: HKD -> USD fixed rate
    private static final double HKD_TO_USD = 0.128; // example

    public double HKD2USD(double amountHKD) {
        return amountHKD * HKD_TO_USD;
    }
}

