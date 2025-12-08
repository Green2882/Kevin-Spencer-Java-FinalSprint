package GymMerchandiseManagement;

public class Food {
    private int merchId;
    private String name;
    private String desc; // Description
    private double cost;
    private int quantity;

    public Food(int merchId, String name, String desc, double cost, int quantity) {
        this.merchId = merchId;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
        this.quantity = quantity;
    }

    public int getMerchId() { 
        return merchId; 
    }

    public void setMerchId(int merchId) { 
        this.merchId = merchId; 
    }

    public String getName() { 
        return name; 
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public String getDesc() { 
        return desc; 
    }

    public void setDesc(String desc) { 
        this.desc = desc; 
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
