import java.util.ArrayList;

public class Pomade extends Cosmetic {
    private String colour;
    private String type;
    private String destination;
    public Pomade(String brand, String name, int price, boolean availability, String colour, String type, String destination, ArrayList<Cosmetic> cosmetic_list) {
        super(brand, name, price, availability, cosmetic_list);
        this.colour = colour;
        this.type = type;
        this.destination = destination;

    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " |Brand " + this.getBrand() + " |Color: " + this.getColour() + " |Type: " + this.getType() + " |Destination " + this.getDestination() + " |Price: " + this.getPrice();
    }

}

