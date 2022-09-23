import java.util.ArrayList;

public class Tonecream extends Cosmetic {
    private String tone;
    private String type;
    private double size;



    public Tonecream(String brand, String name, int price, boolean availability, String colour, String type, double size, ArrayList<Cosmetic> cosmetic_list) {
        super(brand, name, price, availability, cosmetic_list);
        this.tone = colour;
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTone() {
        return tone;
    }

    public void setTone(String tone) {
        this.tone = tone;
    }
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " |Brand: " + this.getBrand() + " |Tone: " + this.getTone() + " |Size: " + this.getSize() + " |Type: " + this.getType() + " |Price: " + this.getPrice();
    }

}
