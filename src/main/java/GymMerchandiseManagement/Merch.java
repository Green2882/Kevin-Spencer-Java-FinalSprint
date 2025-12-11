package GymMerchandiseManagement;


/**
 * Represents merchandise in the gym merchandise management system.
 * This class encapsulates all properties of a merchandise item including
 * name, description, type, cost, and quantity in stock.
 */ 

public class Merch {
    private String name;
    private String merchDesc; // Description
    private String type;
    private double cost;
    private int quantity;

    /**
     * Constructs a new Merch object with specified parameters.
     * 
     * @param name The name of the merchandise item
     * @param merchDesc A brief description of the item
     * @param type The item's category (food, drink, workout gear, etc.)
     * @param cost The cost of the item in dollars
     * @param quantity The number of items in stock
     */
    public Merch(String name, String merchDesc, String type, double cost, int quantity) {
        this.name = name;
        this.merchDesc = merchDesc;
        this.type = type;
        this.cost = cost;
        this.quantity = quantity;
    }

    /**
     * Default constructor for creating an empty Merch object.
     */

    public Merch() {

    }

    /**
     * Gets the name of the merchandise item.
     * 
     * @return the name of the item
     */

    public String getName() {
        return name;
    }

    /**
     * Sets the name of the merchandise item.
     * 
     * @param name the name to set for this item
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the merchandise item.
     * 
     * @return the item description
     */

    public String getMerchDesc() {
        return merchDesc;
    }

    /**
     * Sets the description of the merchandise item.
     * 
     * @param merchDesc the description to set for this item
     */

    public void setMerchDesc(String merchDesc) {
        this.merchDesc = merchDesc;
    }

    /**
     * Gets the type/category of the merchandise item.
     * 
     * @return the item type
     */

    public String getType() {
        return type;
    }

    /**
     * Sets the type/category of the merchandise item.
     * 
     * @param type the type to set for this item
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the cost of the merchandise item.
     * 
     * @return the item cost in dollars
     */

    public double getCost() {
        return cost;
    }

    /**
     * Sets the cost of the merchandise item.
     * 
     * @param cost the cost to set for this item in dollars
     */

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Gets the quantity of items in stock.
     * 
     * @return the quantity of items available
     */

    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of items in stock.
     * 
     * @param quantity the quantity to set for this item
     */

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns a string representation of the merchandise item.
     * 
     * @return the name of the item with its cost formatted as "name: $cost"
     */
    
    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}
