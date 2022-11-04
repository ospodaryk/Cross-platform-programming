import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pizza implements Serializable {
    public String name;
    private int price;
    private int weight;
    private List<Components> componentsList = new ArrayList<>();

    public Pizza(String name, int price, int weight, List<Components> componentsList) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.componentsList = componentsList;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name  +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Components> getComponentsList() {
        return componentsList;
    }

    public void setComponentsList(List<Components> componentsList) {
        this.componentsList = componentsList;
    }
}
