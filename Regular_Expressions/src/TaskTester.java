import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskTester {

    @org.junit.jupiter.api.Test
    void convertStringArrayToStringTest() throws IOException {
        String[] mas = {"Oksana", "Spodaryk", "Lviv"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(mas));
        InformationManager obj=new InformationManager();
        String ourstring= obj.convertStringArrayToString(" ",list);
        int actual = ourstring.length();
        int expected=0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                expected++;
            }
            expected++;
        }
        expected--;
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void readFromFileTest() throws IOException {
        InformationManager obj=new InformationManager();
        ArrayList<String> info1= obj.read("/Users/oksanaspodarik/Documents/JAVA/KPP_5/src/testdata.txt");

        int actual = info1.size();
        int expected=4;
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void divideToSentenceTest() throws IOException {
        InformationManager obj=new InformationManager();
        String str="Hello! How are you? I am Ukranian.";
        int actual = obj.divideToSentence(str).size();
        int expected= (int) str.chars().filter(ch -> ch == '?').count();
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void divideToSentenceEmtyStringTest() throws IOException {
        InformationManager obj=new InformationManager();
        String str="";
        int actual = obj.divideToSentence(str).size();
        int expected= (int) str.chars().filter(ch -> ch == '?').count();
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void divideToWordsExactLengthTest() throws IOException {
        InformationManager obj=new InformationManager();
        String str="";
        ArrayList<String> sentArray=new ArrayList<>();
        sentArray.add("Hello!");
        sentArray.add("How are you?");
        sentArray.add("They are Ukranians.");

        int actual = obj.divideToWordsExactLength(3,sentArray).size();
        int expected= 3;
        Assertions.assertEquals(expected, actual);
    }

}
