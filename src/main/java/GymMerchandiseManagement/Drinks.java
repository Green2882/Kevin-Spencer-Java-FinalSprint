package GymMerchandiseManagement;

public class Drinks {
    private int merchId;
    private String name;
    private String desc; // Description
    private double cost;
    private int quantity;

    public Drinks(int merchId, String name, String desc, double cost, int quantity) {
        this.merchId = merchId;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
        this.quantity = quantity;
    }

    public Drinks() {
    }

    public int getMerchId() { 
        return merchId; 
    }

    public void setMerchId(int merchId) { 
        this.merchId = merchId; 
    }

    public String getDrinkName() { 
        return name; 
    }

    public void setDrinkName(String name) { 
        this.name = name; 
    }

    public String getDrinkDesc() { 
        return desc; 
    }

    public void setDrinkDesc(String desc) { 
        this.desc = desc; 
    }

    public double getDrinkCost() { 
        return cost; 
    }

    public void setDrinkCost(double cost) { 
        this.cost = cost; 
    }

    public int getDrinkQuantity() { 
        return quantity; 
    }

    public void setDrinkQuantity(int quantity) { 
        this.quantity = quantity; 
    }

    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}
