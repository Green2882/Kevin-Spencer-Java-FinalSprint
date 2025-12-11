package GymMerchandiseManagement;

import java.sql.SQLException;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

/**
 * Data Access Object (DAO) for merchandise management in the gym system.
 * Handles all database operations related to merchandise including creating,
 * reading, and calculating inventory values.
 */
public class MerchDAO {

    /**
     * Saves a new merchandise item to the database. Inserts merchandise
     * information including name, description, type, cost, and quantity.
     *
     * @param merch The Merch object containing merchandise details to be saved
     * @throws Exception if database connection fails or SQL execution
     * encounters an error
     */
    public void saveNewMerchItemToDB(Merch merch) {

        String sql = "INSERT INTO merch (name, merchdesc, type, cost, quantity) VALUES (?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, merch.getName());
            preparedStatement.setString(2, merch.getMerchDesc());
            preparedStatement.setString(3, merch.getType());
            preparedStatement.setDouble(4, merch.getCost());
            preparedStatement.setInt(5, merch.getQuantity());
            preparedStatement.executeUpdate();

            Logger.info("Merchandise saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving merchandise to database";
            Logger.error(message + e.getMessage());
        }
    }

    /**
     * Retrieves and displays all merchandise items from the database. Prints a
     * formatted list showing ID, name, type, cost, and quantity for each item.
     *
     * @throws SQLException if database query execution fails
     */
    public void getAllMerchItems() throws SQLException {
        String sql = "SELECT * FROM merch";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            System.out.println("Merchandise Inventory");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("merchId")
                        + " | Name: " + resultSet.getString("name")
                        + " | Type: " + resultSet.getString("type")
                        + " | Cost: $" + resultSet.getDouble("cost")
                        + " | Quantity: " + resultSet.getInt("quantity"));
            }
        }
    }

    /**
     * Calculates the total value of all merchandise in inventory. Computes the
     * sum of (cost × quantity) for all merchandise items.
     *
     * @return The total monetary value of all merchandise as a double
     */
    public double getTotalMerchValue() {
        String sql = "SELECT SUM(cost * quantity) AS totalValue FROM merch";
        double totalValue = 0.0;

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalValue = resultSet.getDouble("totalValue");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error calculating merch value: " + e.getMessage());
        }

        return totalValue;
    }

    /**
     * Updates the cost of a merchandise item. Allows admins to change the price
     * of an existing merch entry.
     *
     * @param merchId The ID of the merchandise item to update
     * @param newCost The new cost value to assign
     */
    public void updateMerchCost(int merchId, double newCost) {

        String sql = "UPDATE merch SET cost = ? WHERE merchId = ?";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDouble(1, newCost);
            preparedStatement.setInt(2, merchId);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                Logger.info("Updated merch cost for ID: " + merchId);
                System.out.println("Merch cost updated successfully!");
            } else {
                System.out.println("No merch found with that ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error updating merch cost: " + e.getMessage());
        }
    }

}
