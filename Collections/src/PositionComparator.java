import java.util.Comparator;
public class PositionComparator implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return s1.getPosition().compareTo(s2.getPosition());
    }
}