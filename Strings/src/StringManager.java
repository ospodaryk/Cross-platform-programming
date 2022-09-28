import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StringManager {
    static final Character open = '“';
    static final Character close = '”';
    static final Character space = ' ';
    static final Character dot = '.';
    private ArrayList<String> maininfoarray = new ArrayList<>();
    private ArrayList<String> words = new ArrayList<>();
    private String maininfostring = "";
    private Map<String, Integer> mapwords = new HashMap<>();

    public StringManager() throws IOException {
        this.maininfoarray = read("/Users/oksanaspodarik/Documents/JAVA/KPP_4/src/OurText.txt");
        this.maininfostring = convertStringArrayToString("\n");
        this.words = splittowords();
        this.mapwords = creatingMapWordsPepeatings();

    }

    public String convertStringArrayToString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String str : maininfoarray)
            sb.append(str).append(delimiter);
        return sb.substring(0, sb.length() - 1);
    }


    public static ArrayList<String> read(String str) throws IOException {
        String tmp = "";
        ArrayList<String> arr = new ArrayList<String>();
        Path path = Paths.get(str);
        Scanner scanner = new Scanner(path);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            arr.add(line);
        }
        return arr;
    }

    public Map<String, Integer> creatingMapWordsPepeatings() {

        Map<String, Integer> mapword
                = new HashMap<String, Integer>();
        for (int i = 0; i < words.size(); i++) {
            Integer count = mapword.get(words.get(i));
            if (count != null) {
                count++;
            } else
                count = 1;
            mapword.put(words.get(i), count);
        }

        return mapword;
    }


    public ArrayList<String> splittowords() {
        ArrayList<String> tmplist = new ArrayList<>();
        String tmpword = "";
        for (int i = 0; i < maininfostring.length(); i++) {
            Character tmp = maininfostring.charAt(i);
            if (!(tmp.equals(space) || tmp.equals(open) || tmp.equals(close) || tmp.equals('\n') || tmp.equals(dot))) {
                tmpword += maininfostring.charAt(i);
            } else {
                if (tmpword.length() != 0) tmplist.add(tmpword);
                tmpword = "";
            }
        }
        return tmplist;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------
    public String deletespace() {
        StringBuilder sb = new StringBuilder(maininfostring);
        int t = 0;
        for (int j = 0; j < maininfostring.length(); j++) {
            Character tmp = maininfostring.charAt(j);
            if (tmp.equals(space)) {
                j++;
                t = j;
                tmp = maininfostring.charAt(j);
                while (tmp.equals(space)) {
                    sb.deleteCharAt(j);
                    maininfostring = sb.toString();
                    tmp = maininfostring.charAt(j);
                }
                j = t;
            }
            j++;
        }
        return maininfostring;
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------------


    public String replaceinq(int i, int count, String maxw) {
        while (i < maininfostring.length()) {
            Character tmp = maininfostring.charAt(i);
            Character tmp2 = maininfostring.charAt(i);
            if (tmp.equals(open)) {
                String word = "";
                i++;
                word += maininfostring.charAt(i);
                while ((!tmp2.equals(close) && (!tmp2.equals(space))) && (!tmp2.equals(dot))) {
                    i++;
                    tmp2 = maininfostring.charAt(i);
                    if ((!tmp2.equals(close) && (!tmp2.equals(space))) && (!tmp2.equals(dot))) {
                        word += maininfostring.charAt(i);
                    }
                }
                StringBuilder sb = new StringBuilder(maininfostring);
                if (word.equals(Words.STRING_ONE.toString()) || word.equals(Words.STRING_TWO.toString()) || word.equals(Words.STRING_Three.toString())) {
                    for (int j = i - word.length(); j < i; j++) {
                        sb.deleteCharAt(i - word.length());
                    }
                    maininfostring = sb.toString();
                    maininfostring = new StringBuilder(maininfostring).insert(i - word.length(), maxw).toString();
                }
            }
            i++;

        }
        return maininfostring;
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void findquotationlist(int i, int count, ArrayList<String> result) {
        while (i < maininfostring.length()) {
            Character tmp = maininfostring.charAt(i);
            Character tmp2 = maininfostring.charAt(i);
            if (tmp.equals(open)) {
                String word = "";
                word += maininfostring.charAt(i);
                count++;
                while ((!tmp2.equals(close)) && (count != 0)) {
                    i++;
                    tmp2 = maininfostring.charAt(i);
                    if (tmp2.equals(open)) {
                        count++;
                        findquotationlist(i, count, result);
                    }
                    word += maininfostring.charAt(i);
                    tmp2 = maininfostring.charAt(i);
                    if (tmp2.equals(close)) {
                        count--;
                        if (count == 1) {
                            word += maininfostring.charAt(i);
                        }
                    }
                }
                result.add(word);
            }
            i++;
        }
    }

    //------------------------------------------------------------------------------------------------------------------------------------------------------------
    public int getMaxOccurrence() {
        int max = 1;
        for (Map.Entry<String, Integer> word :
                mapwords.entrySet()) {
            if (word.getValue() > max) {
                max = word.getValue();
            }
        }
        return max;
    }

    public String findMostRepeatedWord() {
        int max = getMaxOccurrence();
        String maxWord = "";
        for (Map.Entry<String, Integer> word :
                mapwords.entrySet()) {
            if (word.getValue() == max) {
                maxWord = word.getKey();
            }
        }
        return maxWord;
    }
    //------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<String> getMaininfoarray() {
        return maininfoarray;
    }

    public void setMaininfoarray(ArrayList<String> maininfoarray) {
        this.maininfoarray = maininfoarray;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public String getMaininfostring() {
        return maininfostring;
    }

    public void setMaininfostring(String maininfostring) {
        this.maininfostring = maininfostring;
    }

    public Map<String, Integer> getMapwords() {
        return mapwords;
    }

    public void setMapwords(Map<String, Integer> mapwords) {
        this.mapwords = mapwords;
    }
}
