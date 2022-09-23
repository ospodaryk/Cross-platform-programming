public class CalculatorInt {

    public FractionInt findSum(int n) {

        FractionInt start = new FractionInt(1, 1);

        for (int den1 = 2; den1 <= n; den1++) {
            FractionInt tmp = new FractionInt(1, den1);
            start.add(tmp);
        }
        int d = getGCD(start.getNumerator(), start.getDenominator());
        start.setNumerator(start.getNumerator() / d);
        start.setDenominator(start.getDenominator() / d);
        return start;
    }

    static int getGCD(int a, int b) {
        if (b == 0)
            return a;
        return getGCD(b, a % b);

    }

}
