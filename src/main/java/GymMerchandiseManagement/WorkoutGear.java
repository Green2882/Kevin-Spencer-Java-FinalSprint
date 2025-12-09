package GymMerchandiseManagement;

public class WorkoutGear {
    private int merchId;
    private String name;
    private String desc; // Description
    private double cost;
    private int quantity;

    public WorkoutGear(int merchId, String name, String desc, double cost, int quantity) {
        this.merchId = merchId;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
        this.quantity = quantity;
    }

    public WorkoutGear() {
    }

    public int getMerchId() { 
        return merchId; 
    }

    public void setMerchId(int merchId) { 
        this.merchId = merchId; 
    }

    public String getGearName() { 
        return name; 
    }

    public void setGearName(String name) { 
        this.name = name; 
    }

    public String getGearDesc() { 
        return desc; 
    }

    public void setGearDesc(String desc) { 
        this.desc = desc; 
    }

    public double getGearCost() { 
        return cost; 
    }

    public void setGearCost(double cost) { 
        this.cost = cost; 
    }

    public int getGearQuantity() { 
        return quantity; 
    }

    public void setGearQuantity(int quantity) { 
        this.quantity = quantity; 
    }

    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}
