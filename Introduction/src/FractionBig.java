import java.math.BigInteger;
public class FractionBig {
    private BigInteger numerator;
    private BigInteger denominator;
    public FractionBig(BigInteger num, BigInteger den) {
        this.numerator = num;
        this.denominator = den;
    }
    public BigInteger getNumerator() {
        return this.numerator;
    }
    public BigInteger getDenominator() {
        return this.denominator;
    }
    public void setNumerator(BigInteger num) {
        this.numerator = num;
    }
    public void setDenominator(BigInteger den) {
        this.denominator = den;
    }
    public void add(FractionBig obj) {
        this.numerator = (this.numerator.multiply(obj.getDenominator())).add(this.denominator.multiply(obj.getNumerator()));
        this.denominator=  this.denominator.multiply(obj.denominator) ;
    }
    @Override
    public String toString() {
        return this.numerator + " / " + this.denominator;
    }


    //    public long getNumerator() {
//        return isAbove15 ? this.numerator : ((int) this.numerator);
//    }
//
//    public long getDenominator() {
//        return isAbove15 ? (this.denominator) : ((int) this.denominator);
//    }
//
//    public void setNumerator(long num) {
//        this.numerator = num;
//    }
//
//    public void setDenominator(long den) {
//        this.denominator = den;
//    }

}
