import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введіть n : ");
        int n = sc.nextInt();
        if (n > 15) {
            CalculatorBig sum = new CalculatorBig();
            FractionBig obj = sum.findSum(n);
            System.out.println("Result " + obj);
            System.out.println("Type " + ((Object) obj).getClass().getTypeName());
        } else {
            CalculatorInt sum = new CalculatorInt();
            FractionInt obj = sum.findSum(n);
            System.out.println("Result " + obj);
            System.out.println("Type " + ((Object) obj).getClass().getTypeName());
        }
        long b=9l;
        int a=(int)b;
    }
}