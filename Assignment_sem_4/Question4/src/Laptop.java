public class Laptop {
    private String model;
    private double price;
    public Laptop() {
        this.model = "Null";
        this.price = 0.0;
    }

    // Constructor with parameters
    public Laptop(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "New Laptop Model: " + model + ", New Laptop Price: $" + price;
    }
}
