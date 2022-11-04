import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cafe implements Serializable {

    private List<Pizza> menuList = new ArrayList<>();
    private List<Customer> customersList = new ArrayList<>();

    public Cafe(List<Pizza> menuList, List<Customer> customersList) {
        this.menuList = menuList;
        this.customersList = customersList;
    }

    public void sortByTime() {
        customersList = customersList.stream()
                .sorted(Comparator.comparing(Customer::getTime_delivery))
                .collect(Collectors.toList());
        System.out.println("-Sort by time----------------------------------------------------------------------------------------------------------------------------------------------------------");
        printList(customersList);
    }

    public void findMoreThanTwo() {

        List<Customer> moreThan2 = customersList.stream()
                .filter(s -> s.getOrderList().size() > 2)
                .collect(Collectors.toList());
        System.out.println("-Find more than 2 items in order----------------------------------------------------------------------------------------------------------------------------------------");

        printList(moreThan2);
    }

    public void findOrdersExactPizza(String name) {

        var count = customersList.stream()
                .filter(s -> s.existName(name))
                .collect(Collectors.toList());
        System.out.println("-Find Orders where is " + name + "-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(count);
        System.out.println("Count" + count.size());

    }

    public void findMaxOrders() {
        Customer count = customersList.stream()
                .max(Comparator.comparingInt(Customer::getOrderListSize))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("-Find Orders with max count of Pizza-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(count);
        System.out.println("Count" + count.getOrderListSize());

    }

    public void notDelieveried() {
        System.out.println("---------------------------Not Delievered---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        List<Customer> notDeliveried = customersList.stream()
                .filter(s -> s.isDone())
                .collect(Collectors.toList());
        printList(notDeliveried);

    }

    public void getCustomersByPizza() {
        System.out.println("---------------------------Map Pizza and Customer---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        var result = new TreeMap<String, List<Integer>>();
        menuList.forEach(pizza -> {
                    var customers = customersList.stream()
                            .filter(o -> o.getOrderList().stream()
                                    .anyMatch(p -> p.name.equals(pizza.getName())))
                            .map(Customer::getIdOrder)
                            .distinct().collect(Collectors.toList());
                    result.put(pizza.getName(), customers);
                }
        );
        result.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    public void printList(List<Customer> moreThan2) {
        moreThan2.forEach(System.out::println);
    }


    public List<Pizza> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Pizza> menuList) {
        this.menuList = menuList;
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customer> customersList) {
        this.customersList = customersList;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                " menuList=" + menuList +
                ", customersList=" + customersList +
                '}';
    }
}
