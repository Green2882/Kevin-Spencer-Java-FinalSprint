package GymMerchandiseManagement;

import java.sql.SQLException;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

public class MerchDAO {

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

}
