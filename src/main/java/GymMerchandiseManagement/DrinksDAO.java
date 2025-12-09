package GymMerchandiseManagement;

import java.sql.SQLException;
import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

public class DrinksDAO {

    public void saveNewDrinkToDB(Drinks drinks) {

        String sql = "INSERT INTO drinks (merchId, name, merchdesc, cost, quantity) VALUES (?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, drinks.getMerchId());
            preparedStatement.setString(2, drinks.getDrinkName());
            preparedStatement.setString(3, drinks.getDrinkDesc());
            preparedStatement.setDouble(4, drinks.getDrinkCost());
            preparedStatement.setInt(5, drinks.getDrinkQuantity());
            preparedStatement.executeUpdate();

            Logger.info("Drinks saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving Drinks to database";
            Logger.error(message + e.getMessage());
        }
    }

    public void getAllDrinkItems() throws SQLException {
        String sql = "SELECT * FROM drinks";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            System.out.println("Drinks Inventory");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("merchId") + 
                    " | Name: " + resultSet.getString("name") + 
                    " | Cost: $" + resultSet.getDouble("cost") + 
                    " | Quantity: " + resultSet.getInt("quantity"));
            }
        }
    }
}
