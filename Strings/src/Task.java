import java.io.IOException;
import java.util.ArrayList;

public class Task {
    public StringManager obj = new StringManager();

    public Task() throws IOException {
    }

    public void task1() {
        System.out.println(obj.deletespace());
    }

    public void task2() {
        ArrayList<String> quotationlist = new ArrayList<>();
        obj.findquotationlist(0, 0, quotationlist);
        for (int j = 0; j < quotationlist.size(); j++) {
            System.out.println(quotationlist.get(j));
        }
    }

    public void task3() {
        System.out.println("Most Repeated word: " + obj.findMostRepeatedWord());
        obj.replaceinq(0, 0, obj.findMostRepeatedWord());
        System.out.println(obj.getMaininfostring());
    }
}
