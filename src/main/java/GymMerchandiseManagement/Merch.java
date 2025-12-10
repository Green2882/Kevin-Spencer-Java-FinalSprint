package GymMerchandiseManagement;

public class Merch {
    private String name;
    private String merchDesc; // Description
    private String type;
    private double cost;
    private int quantity;

    public Merch(String name, String merchDesc, String type, double cost, int quantity) {
        this.name = name;
        this.merchDesc = merchDesc;
        this.type = type;
        this.cost = cost;
        this.quantity = quantity;
    }

    public Merch() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchDesc() {
        return merchDesc;
    }

    public void setMerchDesc(String merchDesc) {
        this.merchDesc = merchDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}
