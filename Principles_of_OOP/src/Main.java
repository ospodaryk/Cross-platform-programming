import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cosmetic> cosmeticlist = new ArrayList<Cosmetic>();
        Pomade obj1 = new Pomade("L’Oreal", "SuperPomade", 10, true, "black", "Cutie", "Догляд", cosmeticlist);
        Pomade obj2 = new Pomade("Clinique", "THeBest", 1, false, "black", "Cutie", "Догляд", cosmeticlist);
        Pomade obj3 = new Pomade("Guerlain", "Perfect", 12, false, "black", "Cutie", "Догляд", cosmeticlist);
        Pomade obj4 = new Pomade("Shiseido", "Wow", 3, false, "black", "Cutie", "Догляд", cosmeticlist);
        Tonecream tc = new Tonecream("Garnier", "SuperSKin", 122, true, "b1", "tjin", 100, cosmeticlist);
        SortingManager sorobj = new SortingManager(cosmeticlist);
        sorobj.print(cosmeticlist);
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int tmp = 2;
        while (tmp != 0) {
            System.out.println("За яким методом обираєте сортувати?\nЗа ціною (0) \nЗа брендом(1)\nЗа наявністю(2)\nЗа Ім'ям(3)");
            int k = sc.nextInt();
            switch (k) {
                case 0:
                    sc = new Scanner(System.in);
                    System.out.print("Сортувати по зростанню(1) чи по спаданню(0)?  ");
                    n = sc.nextInt();
                    ArrayList<Cosmetic> sortarray1 = sorobj.getArr();
                    if (n == 1) {
                        sortarray1.sort(new SortingManager(cosmeticlist).new PriceComparator(true));
                    } else {
                        sortarray1.sort(new SortingManager(cosmeticlist).new PriceComparator(false));
                    }
                    sorobj.setArr(sortarray1);
                    sorobj.print();
                    System.out.println("Продовжити сортування? Так(1) Ні(0)");

                    sc = new Scanner(System.in);
                    tmp = sc.nextInt();

                    break;
                case 1:
                    sc = new Scanner(System.in);
                    System.out.print("Сортувати по зростанню(1) чи по спаданню(0)?  ");
                    n = sc.nextInt();
                    ArrayList<Cosmetic> sortarray = sorobj.getArr();
                    if (n == 1) {
                        sortarray.sort(new SortingManager.BrandComparator(true));
                    } else {
                        sortarray.sort(new SortingManager.BrandComparator(false));
                    }
                    sorobj.setArr(sortarray);
                    sorobj.print();
                    System.out.println("Продовжити сортування? Так(1) Ні(0)");
                    sc = new Scanner(System.in);
                    tmp = sc.nextInt();
                    break;
                case 2:
                    ArrayList<Cosmetic> newlist = new ArrayList<Cosmetic>();
                    sc = new Scanner(System.in);
                    System.out.print("Знайти чи є в наявності(1) чи відсутній товар(0)?  ");
                    n = sc.nextInt();
                    if (n == 1) {
                        sorobj.sortingbyavailible(newlist, true);
                    } else {
                        sorobj.sortingbyavailible(newlist, false);
                    }
                    sorobj.print(newlist);
                    System.out.println("Продовжити сортування? Так(1) Ні(0)");
                    sc = new Scanner(System.in);
                    tmp = sc.nextInt();
                    break;
                case 3:
                    sc = new Scanner(System.in);
                    System.out.print("Сортувати по зростанню(1) чи по спаданню(0)?  ");
                    n = sc.nextInt();
                    if (n == 1) {
                        sorobj.sortByName(true);
                    } else {
                        sorobj.sortByName(false);
                    }
                    sorobj.print(sorobj.getArr());
                    System.out.println("Продовжити сортування? Так(1) Ні(0)");
                    sc = new Scanner(System.in);
                    tmp = sc.nextInt();
                    break;
                default:
                    tmp = 0;
                    break;
            }
        }
        System.out.print("Скільки Коштів? ");
        double money = sc.nextDouble();
        ArrayList<Cosmetic> money_list = new ArrayList<Cosmetic>();
        cosmeticlist.sort(new SortingManager.BrandComparator(true));
        sorobj.countMoney(cosmeticlist,money_list, money);
        sorobj.print(money_list);
    }
}