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

    public Food() {
    }

    public int getMerchId() { 
        return merchId; 
    }

    public void setMerchId(int merchId) { 
        this.merchId = merchId; 
    }

    public String getFoodName() { 
        return name; 
    }

    public void setFoodName(String name) { 
        this.name = name; 
    }

    public String getFoodDesc() { 
        return desc; 
    }

    public void setFoodDesc(String desc) { 
        this.desc = desc; 
    }

    public double getFoodCost() { 
        return cost; 
    }

    public void setFoodCost(double cost) { 
        this.cost = cost; 
    }

    public int getFoodQuantity() { 
        return quantity; 
    }

    public void setFoodQuantity(int quantity) { 
        this.quantity = quantity; 
    }

    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}
