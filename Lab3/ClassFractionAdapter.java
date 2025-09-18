// ClassFractionAdapter.java
public class ClassFractionAdapter extends LongFraction implements Fraction {

    public ClassFractionAdapter(int num, int den) {
        super(num, den);
    }

    private ClassFractionAdapter(LongFraction lf) {
        super(lf.numerator(), lf.denominator());
    }

    @Override
    public int getNumerator() {
        long n = numerator(); // inherited
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE)
            throw new ArithmeticException("numerator overflows int");
        return (int) n;
    }

    @Override
    public int getDenominator() {
        long d = denominator(); // inherited
        if (d > Integer.MAX_VALUE || d < Integer.MIN_VALUE)
            throw new ArithmeticException("denominator overflows int");
        return (int) d;
    }

    @Override
    public Fraction add(Fraction b) {
        LongFraction sum = this.plus(new LongFraction(b.getNumerator(), b.getDenominator()));
        return new ClassFractionAdapter(sum);
    }

    @Override
    public Fraction add(int b) {
        LongFraction sum = this.plus((long) b);
        return new ClassFractionAdapter(sum);
    }

    @Override
    public Fraction subtract(Fraction b) {
        LongFraction diff = this.minus(new LongFraction(b.getNumerator(), b.getDenominator()));
        return new ClassFractionAdapter(diff);
    }

    @Override
    public Fraction subtract(int b) {
        LongFraction diff = this.minus((long) b);
        return new ClassFractionAdapter(diff);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

