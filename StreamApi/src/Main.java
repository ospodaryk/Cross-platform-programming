import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pizza> menu = new ArrayList<>();
        initMenu(menu);
        List<Customer> customers = new ArrayList<>();
        initListCustomers(customers, menu);
        Cafe cafe1 = new Cafe(menu, customers);


        cafe1.sortByTime();
        cafe1.findMoreThanTwo();
        Scanner sc = new Scanner(System.in);
        System.out.println("=============================================================================================================================================================================================");
        System.out.println("What pizza to find?\nHawaii(0)\nCesar(1)\nGreek(2)\nPeperoni(3)");
        int k = sc.nextInt();
        if ((k < 0) || (k > 3)) {
            System.out.println("ERROR NAME");
        } else {
            cafe1.findOrdersExactPizza(menu.get(k).getName());
        }
        cafe1.findMaxOrders();
        cafe1.getCustomersByPizza();
        cafe1.notDelieveried();
    }

    static public void initListCustomers(List<Customer> customers, List<Pizza> menu) {
        List<Pizza> order1 = new ArrayList<>();
        order1.add(menu.get(0));
        order1.add(menu.get(3));
        LocalTime time = LocalTime.now();
        customers.add(new Customer(1, time.minusMinutes(30), order1, true));


        List<Pizza> order2 = new ArrayList<>();
        order2.add(menu.get(2));
        order2.add(menu.get(1));
        customers.add(new Customer(2, time.plusMinutes(15), order2, false));

        List<Pizza> order3 = new ArrayList<>();
        order3.add(menu.get(0));
        order3.add(menu.get(3));
        customers.add(new Customer(3, time.minusMinutes(60), order3, true));

        List<Pizza> order4 = new ArrayList<>();
        order4.add(menu.get(2));
        order4.add(menu.get(1));
        order4.add(menu.get(3));
        order4.add(menu.get(0));
        customers.add(new Customer(4, time.minusMinutes(35), order4, false));
    }

    static public void initMenu(List<Pizza> menu) {
        List<Components> componentsHawai = new ArrayList<>();
        Collections.addAll(componentsHawai, Components.CHEESE, Components.PINEAPPLE, Components.CHICKEN);
        menu.add(new Pizza("Hawaii", 200, 520, componentsHawai));


        List<Components> componentsCesar = new ArrayList<>();
        Collections.addAll(componentsCesar, Components.TOMATO, Components.CHICKEN, Components.PROSCIUTTO);
        menu.add(new Pizza("Cesar", 350, 600, componentsCesar));


        List<Components> componentsGreek = new ArrayList<>();
        Collections.addAll(componentsGreek, Components.OLIVES, Components.TOMATO, Components.CHEESE);
        menu.add(new Pizza("Greek", 340, 350, componentsGreek));


        List<Components> componentsPeperoni = new ArrayList<>();
        Collections.addAll(componentsPeperoni, Components.PEPPER, Components.SAUSAGES, Components.CHEESE);
        menu.add(new Pizza("Peperoni", 380, 400, componentsPeperoni));

    }
}