package GymMerchandiseManagement;

import Logger.Logger;

/**
 * Service layer for merchandise management in the gym system. Provides business
 * logic operations for merchandise including inventory management, stock
 * reporting, and product viewing with role-based access control.
 */
public class MerchService {

    private MerchDAO merchDAO = new MerchDAO();

    /**
     * Adds new merchandise to the inventory (Admin operation). Saves
     * merchandise to database and logs the operation for audit purposes.
     *
     * @param merch The Merch object containing details of the new merchandise
     * item
     */
    public void addNewMerch(Merch merch) {
        System.out.println("Adding new merchandise: " + merch.getName());
        merchDAO.saveNewMerchItemToDB(merch);
        Logger.info("New merchandise added: " + merch.getName());
        System.out.println("Merchandise added to inventory!");
    }

    /**
     * Generates and displays a complete stock report (Admin operation). Shows
     * all merchandise items with detailed information including quantities.
     * Includes error handling and logging for audit trails.
     */
    public void printStockReport() {
        try {
            System.out.println("Complete Stock Report");
            merchDAO.getAllMerchItems();
            Logger.info("Stock report generated");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error generating stock report: " + e.getMessage());
            System.out.println("Error generating stock report.");
        }
    }

    /**
     * Displays all available products for viewing (Member and Trainer
     * operation). Shows product listings without sensitive inventory details.
     * Includes error handling for improved user experience.
     */
    public void viewAllProducts() {
        try {
            System.out.println("Available Products");
            merchDAO.getAllMerchItems();
            Logger.info("Product listing displayed");
        } catch (Exception e) {
            Logger.error("Error displaying products: " + e.getMessage());
            System.out.println("Error displaying products.");
        }
    }

    /**
     * Calculates and displays the total monetary value of all merchandise.
     * Provides financial reporting for inventory valuation purposes. Formats
     * the output with proper currency display and logs the operation.
     */
    public void viewTotalMerchValue() {
        System.out.println("Merchandise Stock Value Report");

        double totalValue = merchDAO.getTotalMerchValue();

        System.out.println("Total Merchandise Value: $" + String.format("%.2f", totalValue));
        Logger.info("Stock value report displayed: $" + totalValue);
    }

    /**
     * Updates the cost of an existing merchandise item (Admin operation).
     * Provides feedback and logs update activity.
     *
     * @param merchId The ID of the merchandise item
     * @param newCost The new cost to assign
     */
    public void updateMerchCost(int merchId, double newCost) {
        System.out.println("Updating cost for merch ID: " + merchId);
        merchDAO.updateMerchCost(merchId, newCost);
    }

}
