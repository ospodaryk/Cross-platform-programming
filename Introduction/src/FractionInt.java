public class FractionInt {
    private int numerator;
    private int denominator;
    public FractionInt(int num, int den) {
        this.numerator = num;
        this.denominator = den;
    }
    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int num) {
        this.numerator = num;
    }

    public void setDenominator(int den) {
        this.denominator = den;
    }

    public void add(FractionInt obj) {
        this.numerator = this.numerator * obj.getDenominator() + this.denominator * obj.getNumerator();
        this.denominator *= obj.denominator;
    }

    @Override
    public String toString() {
        return this.numerator + " / " + this.denominator ;
    }


    //    public long getNumerator() {
//        return isAbove15 ? this.numerator : ((int) this.numerator);
//    }
//
//    public long getDenominator() {
//        return isAbove15 ? (this.denominator) : ((int) this.denominator);
//    }
//

}
