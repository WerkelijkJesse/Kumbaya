package zeroXessApp.ClassObjects;

public abstract class Animals {

    private String cattle, name, gender, color;
    private double weight;
    private int price;
    private String addedBy;

    public Animals(String cattle, String name, String gender, String color, double weight, String addedBy) {
        this.cattle = cattle;
        this.name = name;
        this.gender = gender;
        this.color = color;
        this.weight = weight;
        this.addedBy = addedBy;
    }

    public String getCattle() { return this.cattle; }

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public String getColor() {
        return this.color;
    }

    public int getPrice() { return this.price; }

    public double getWeight() {
        return this.weight;
    }

    public void setPrice (Integer price) { this.price = price; }

    public String getAddedBy() {
        return this.addedBy;
    }

    public String toString() {
        return this.cattle + " " + this.name + " " + this.gender + " " + this.color + " " + this.price + " " + this.weight;
    }
}
