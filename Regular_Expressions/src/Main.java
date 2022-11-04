import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        InformationManager obj = new InformationManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("=====Уся інформація=====");
obj.getMainInformationArray().forEach(System.out::println);
        System.out.println("=====Питальні речення=====");
        obj.getSentencesArray().forEach(System.out::println);
        System.out.println("==========================");

        System.out.print("Введіть бажану довжину слова ");
        int n = sc.nextInt();
        System.out.println("====Слова з довжиною "+n+" ====");
        Set<String> divideToWordsExactLength = new HashSet<>();
        divideToWordsExactLength = obj.divideToWordsExactLength(n, obj.getSentencesArray());
    }
}