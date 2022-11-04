import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationManager {
    private String allInformation = "";
    private ArrayList<String> mainInformationArray = new ArrayList<>();
    private ArrayList<String> sentencesArray = new ArrayList<>();
    public InformationManager() throws IOException {
        this.mainInformationArray = read("/Users/oksanaspodarik/Documents/JAVA/KPP_5/src/data.txt");
        this.allInformation = convertStringArrayToString(" ", mainInformationArray);
        this.sentencesArray = divideToSentence(allInformation);
    }

    public Set<String> divideToWordsExactLength(int k, ArrayList<String> sentences) {
        Set<String> words = new HashSet<>();
        if (sentences.isEmpty()) {
            System.out.println("Запитальні речення відсутні :(");
        } else {
            String regexExpression = "\\b[a-zA-Z]{" + k + "}\\b";
            Pattern p = Pattern.compile(regexExpression);
            for (String s : sentences) {
                Matcher m = p.matcher(s);
                while (m.find()) {
                    words.add(m.group());
                }
            }
            if (words.isEmpty()) {
                System.out.println("Cлова з довжиною " + k + " відсутні :(");
            } else {
                words.forEach(System.out::println);
            }
        }
        return words;
    }

    public ArrayList<String> divideToSentence(String str) {
        ArrayList<String> tmp = new ArrayList<>();

        Pattern pattern = Pattern.compile("([^.?!]*)\\?");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            tmp.add(matcher.group(0));
        }
        return tmp;

    }

    public String convertStringArrayToString(String delimiter, ArrayList<String> mainString) {
        StringBuilder sb = new StringBuilder();
        for (String str : mainString)
            sb.append(str).append(delimiter);
        return sb.substring(0, sb.length() - 1);
    }


    public ArrayList<String> read(String str) throws IOException {
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

    public String getAllInformation() {
        return allInformation;
    }

    public void setAllInformation(String allInformation) {
        this.allInformation = allInformation;
    }

    public ArrayList<String> getMainInformationArray() {
        return mainInformationArray;
    }

    public void setMainInformationArray(ArrayList<String> mainInformationArray) {
        this.mainInformationArray = mainInformationArray;
    }

    public ArrayList<String> getSentencesArray() {
        return sentencesArray;
    }

    public void setSentencesArray(ArrayList<String> sentencesArray) {
        this.sentencesArray = sentencesArray;
    }
}
