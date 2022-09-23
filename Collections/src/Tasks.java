import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Tasks {
    public Map<Integer, List<String>> task1_CreateMapWithMultiValuees(ArrayList<String> fulldate, List<Employee> employees) {

        for (int j = 0; j < employees.size(); j++) {
            employees.sort(new PositionComparator());
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (int j = 0; j < fulldate.size(); j++) {
            map.computeIfAbsent(employees.get(j).getDate(), k -> new ArrayList<>()).add(employees.get(j).getSurname() + " " + employees.get(j).getPosition());
        }

        return map;
    }

    public void task2_RemoveYoung(Map<Integer, List<String>> map) {
        for (Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            Integer key = iterator.next();
            if (key > 2012) {
                iterator.remove();
            }
        }
    }

    public Map<String, List<String>> task3(Map<String, List<String>> mapbyname1, Map<String, List<String>> mapbyname2) {
        Map<String, List<String>> result = new HashMap<String, List<String>>(mapbyname1);
        result.putAll(mapbyname2);
        return result;
    }

    public void printIS(Map<Integer, List<String>> map) {
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            System.out.println("Key: " +entry.getKey() + " | Value: " + entry.getValue());
        }
        System.out.println("=====================================================");
    }

    public void printSS(Map<String, List<String>> mapbyname) {
        for (Map.Entry<String, List<String>> entry : mapbyname.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println("=====================================================");
    }



    public Map<String, List<String>> createMapByName(ArrayList<String> fulldate, List<Employee> employees) {
        Map<String, List<String>> mapbyname = new HashMap<>();
        for (int j = 0; j < fulldate.size(); j++) {
            mapbyname.put(employees.get(j).getSurname(), employees.get(j).getAdditional());
        }
        return mapbyname;
    }

    public static class ReadFromFile {
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
    }
}