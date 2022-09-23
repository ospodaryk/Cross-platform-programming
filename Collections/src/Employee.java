import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String surname;
    private String position;
    private Integer date;

    public Employee(String fulldate) {
        String[] tmp = fulldate.split(" ");
        this.surname = tmp[0];
        this.position = tmp[1];
        this.date = Integer.parseInt(tmp[2]);
    }

    public List<String> getAdditional() {
        List<String> arr = new ArrayList<>();
        arr.add(position);
        arr.add(date.toString());
        return arr;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Surname: " + this.getSurname() + " |Date " + this.getDate() + " |Position: " + this.getPosition();
    }


}
