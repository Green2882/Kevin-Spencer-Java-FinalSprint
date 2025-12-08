package GymMerchandiseManagement;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

public class FoodsDAO {

    public void saveNewFoodToDB(Food food) {

        String sql = "INSERT INTO food (merchId, name, desc, cost, quantity) VALUES (?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, food.getMerchId());
            preparedStatement.setString(2, food.getName());
            preparedStatement.setString(3, food.getDesc());
            preparedStatement.setDouble(4, food.getCost());
            preparedStatement.setInt(5, food.getQuantity());

            Logger.info("Food saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving food to database";
            Logger.error(message + e.getMessage());
        }
    }
}
