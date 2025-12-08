package GymMerchandiseManagement;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

public class DrinksDAO {

    public void saveNewDrinkToDB(Drinks drinks) {

        String sql = "INSERT INTO drinks (merchId, name, desc, cost, quantity) VALUES (?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, drinks.getMerchId());
            preparedStatement.setString(2, drinks.getName());
            preparedStatement.setString(3, drinks.getDesc());
            preparedStatement.setDouble(4, drinks.getCost());
            preparedStatement.setInt(5, drinks.getQuantity());

            Logger.info("Drinks saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving Drinks to database";
            Logger.error(message + e.getMessage());
        }
    }
}
