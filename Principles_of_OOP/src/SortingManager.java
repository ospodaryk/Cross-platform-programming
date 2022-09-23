import java.util.ArrayList;
import java.util.*;
import java.util.Comparator;

abstract class SortAvailability {
    abstract void sorting();
}

public class SortingManager {
    private ArrayList<Cosmetic> arr = new ArrayList<Cosmetic>();

    public ArrayList<Cosmetic> getArr() {
        return arr;
    }

    public void setArr(ArrayList<Cosmetic> arr) {
        this.arr = arr;
    }

    public SortingManager(ArrayList<Cosmetic> arr) {
        this.arr = arr;
    }

    //Додати ще один метод сортування (додатковий), який реалізує снортування з використанням анонімного класу (anonymous inner class)
    public void sortingbyavailible(ArrayList<Cosmetic> tmp, boolean check) {
        SortAvailability d = new SortAvailability() {
            void sorting() {
                if (check) {
                    for (Cosmetic cosmetic : arr) {
                        if (cosmetic.isAvailability()) {
                            tmp.add(cosmetic);
                        }
                    }
                } else {
                    for (Cosmetic cosmetic : arr) {
                        if (!cosmetic.isAvailability()) {
                            tmp.add(cosmetic);
                        }
                    }
                }
            }
        };
        d.sorting();
    }

    //Додати ще один, 4-й метод сортування з використанням лямбда-виразів .
    public void sortByName(boolean check) {
        if (check) {
            Collections.sort(arr, (Cosmetic p1, Cosmetic p2) -> p1.getName().compareTo(p2.getName()));
        } else {
            Collections.sort(arr, (Cosmetic p2, Cosmetic p1) -> p1.getName().compareTo(p2.getName()));
        }
    }


    //Реалізувати один з методів сортування з використанням компаратора, реалізованого як статичний вкладений клас
    public static class BrandComparator implements Comparator<Cosmetic> {
        private boolean check = true;

        public BrandComparator(boolean check) {
            this.check = check;
        }

        public int compare(Cosmetic s1, Cosmetic s2) {
            if (!check) {
                return s2.getBrand().compareTo(s1.getBrand());
            } else {
                return s1.getBrand().compareTo(s2.getBrand());
            }
        }
    }

    //Реалізувати наступний з методів сортування з використанням компаратора,
    //реалізованого як вкладений клас (inner class)
    public class PriceComparator implements Comparator<Cosmetic> {
        boolean check = true;
        public PriceComparator(boolean check) {
            this.check = check;
        }

        public int compare(Cosmetic s1, Cosmetic s2) {
            if (!check) {
                return s2.getPrice() - (s1.getPrice());
            } else {
                return s1.getPrice() - (s2.getPrice());
            }
        }
    }

    //Пошук на суму------------------------------------------------------------------------------
    public void countMoney(ArrayList<Cosmetic> arr, ArrayList<Cosmetic> cash_list, double cash) {
        for (Cosmetic cosmetic : arr) {
            if (cash >= cosmetic.getPrice()) {
                cash_list.add(cosmetic);
                cash = cash - cosmetic.getPrice();
            }
        }
        if (cash_list.isEmpty()) {
            System.out.println("Вибач друже,але на твою суму немає товару ");
        }
    }

    public void print() {
        System.out.println("--------------------------------------------------------------------------------------");
        for (Cosmetic cosmetic : arr) {
            System.out.println(cosmetic);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void print(ArrayList<Cosmetic> cosmetic_list) {
        System.out.println("--------------------------------------------------------------------------------------");
        for (Cosmetic cosmetic : cosmetic_list) {
            System.out.println(cosmetic);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}
