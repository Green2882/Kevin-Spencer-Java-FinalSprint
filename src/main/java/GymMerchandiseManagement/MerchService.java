package GymMerchandiseManagement;

import Logger.Logger;

public class MerchService {

    private MerchDAO merchDAO = new MerchDAO();

    // Admin operations - add new items
    public void addNewMerch(Merch merch) {
        System.out.println("Adding new merchandise: " + merch.getName());
        merchDAO.saveNewMerchItemToDB(merch);
        Logger.info("New merchandise added: " + merch.getName());
        System.out.println("Merchandise added to inventory!");
    }

    // Print stock report for admins
    public void printStockReport() {
        try {
            System.out.println("Complete Stock Report");
            merchDAO.getAllMerchItems();
            Logger.info("Stock report generated");
        } catch (Exception e) {
            Logger.error("Error generating stock report: " + e.getMessage());
            System.out.println("Error generating stock report.");
        }
    }

    // View products (for members and trainers)
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

}
