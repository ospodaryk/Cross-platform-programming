import java.math.BigInteger;
public class CalculatorBig {
    private final BigInteger one = BigInteger.valueOf(1);
    public FractionBig findSum(int n) {
        FractionBig start = new FractionBig(one, one);
        for (int i = 2; i <= n; i++) {
            FractionBig tmp = new FractionBig(BigInteger.valueOf(1), BigInteger.valueOf(i));
            start.add(tmp);
        }
        BigInteger d = getGCD(start.getNumerator(), start.getDenominator());
        start.setNumerator(start.getNumerator().divide(d));
        start.setDenominator(start.getDenominator().divide(d));
        return start;
    }
    static BigInteger getGCD(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) == 0)
            return a;
        return getGCD(b, a.mod(b));
    }
}
