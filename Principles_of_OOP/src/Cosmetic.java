import java.util.ArrayList;

public class Cosmetic {
    private String brand;
    private String name;
    private int price;
    private boolean availability;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Cosmetic() {

    }

    public Cosmetic(String brand, String name, int price, boolean availability, ArrayList<Cosmetic> cosmetic_list) {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availability = availability;
        cosmetic_list.add(this);

    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


}
