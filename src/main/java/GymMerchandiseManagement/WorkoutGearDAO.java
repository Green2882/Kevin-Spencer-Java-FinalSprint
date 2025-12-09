package GymMerchandiseManagement;

import java.sql.SQLException;
import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

public class WorkoutGearDAO {

    public void saveNewWorkoutGearToDB(WorkoutGear workoutGear) {

        String sql = "INSERT INTO workoutGear (merchId, name, merchdesc, cost, quantity) VALUES (?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, workoutGear.getMerchId());
            preparedStatement.setString(2, workoutGear.getGearName());
            preparedStatement.setString(3, workoutGear.getGearDesc());
            preparedStatement.setDouble(4, workoutGear.getGearCost());
            preparedStatement.setInt(5, workoutGear.getGearQuantity());
            preparedStatement.executeUpdate();

            Logger.info("Workout Gear saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving Workout Gear to database";
            Logger.error(message + e.getMessage());
        }
    }

    public void getAllGearItems() throws SQLException {
        String sql = "SELECT * FROM workoutgear";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("name") + " $" + resultSet.getDouble("cost"));
            }
        }
    }
}
