package GymMerchandiseManagement;

import java.sql.SQLException;
import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

public class FoodsDAO {

    public void saveNewFoodToDB(Food food) {

        String sql = "INSERT INTO food (merchId, name, merchdesc, cost, quantity) VALUES (?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, food.getMerchId());
            preparedStatement.setString(2, food.getFoodName());
            preparedStatement.setString(3, food.getFoodDesc());
            preparedStatement.setDouble(4, food.getFoodCost());
            preparedStatement.setInt(5, food.getFoodQuantity());
            preparedStatement.executeUpdate();

            Logger.info("Food saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving food to database";
            Logger.error(message + e.getMessage());
        }
    }

    public void getAllFoodItems() throws SQLException {
        String sql = "SELECT * FROM food";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            System.out.println("Food Inventory");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("merchId") + 
                    " | Name: " + resultSet.getString("name") + 
                    " | Cost: $" + resultSet.getDouble("cost") + 
                    " | Quantity: " + resultSet.getInt("quantity"));
            }
        }
    }
}
