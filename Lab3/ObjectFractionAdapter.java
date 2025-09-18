// ObjectFractionAdapter.java
public class ObjectFractionAdapter implements Fraction {
    private final LongFraction adaptee;

    public ObjectFractionAdapter(int num, int den) {
        this.adaptee = new LongFraction(num, den);
    }

    private ObjectFractionAdapter(LongFraction lf) {
        this.adaptee = lf;
    }

    @Override
    public int getNumerator() {
        long n = adaptee.numerator();  // <-- use numerator()
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE)
            throw new ArithmeticException("numerator overflows int");
        return (int) n;
    }

    @Override
    public int getDenominator() {
        long d = adaptee.denominator(); // <-- use denominator()
        if (d > Integer.MAX_VALUE || d < Integer.MIN_VALUE)
            throw new ArithmeticException("denominator overflows int");
        return (int) d;
    }

    @Override
    public Fraction add(Fraction b) {
        LongFraction other = new LongFraction(b.getNumerator(), b.getDenominator());
        LongFraction sum = adaptee.plus(other);           // <-- plus(LongFraction)
        return new ObjectFractionAdapter(sum);
    }

    @Override
    public Fraction add(int b) {
        LongFraction sum = adaptee.plus((long) b);        // <-- plus(long)
        return new ObjectFractionAdapter(sum);
    }

    @Override
    public Fraction subtract(Fraction b) {
        LongFraction other = new LongFraction(b.getNumerator(), b.getDenominator());
        LongFraction diff = adaptee.minus(other);         // <-- minus(LongFraction)
        return new ObjectFractionAdapter(diff);
    }

    @Override
    public Fraction subtract(int b) {
        LongFraction diff = adaptee.minus((long) b);      // <-- minus(long)
        return new ObjectFractionAdapter(diff);
    }

    @Override
    public String toString() {
        return adaptee.toString();
    }
}

