import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<String> info1 = new Tasks.ReadFromFile().read("/Users/oksanaspodarik/Documents/JAVA/KPP_3/src/1.txt");
        List<Employee> crew1 = new ArrayList<>();
        for (int j = 0; j < info1.size(); j++) {
            crew1.add(new Employee(info1.get(j)));
        }
        //1--------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("TASK 1");
        Tasks obj = new Tasks();
        Map<Integer, List<String>> map1 = obj.task1_CreateMapWithMultiValuees(info1, crew1);
        obj.printIS(map1);

        //2--------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("TASK 2");
        obj.task2_RemoveYoung(map1);
        obj.printIS(map1);

        //3--------------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("TASK 3");
        Map<String, List<String>> mapbyname1 = new Tasks().createMapByName(info1, crew1);
        ArrayList<String> info2 = new Tasks.ReadFromFile().read("/Users/oksanaspodarik/Documents/JAVA/KPP_3/src/2.txt");
        List<Employee> crew2 = new ArrayList<>();
        for (int i = 0; i < info2.size(); i++) {
            crew2.add(new Employee(info2.get(i)));
        }
        Map<String, List<String>> mapbyname2 = new Tasks().createMapByName(info2, crew2);
        Map<String, List<String>> result = obj.task3(mapbyname1, mapbyname2);
        obj.printSS(result);
    }
}