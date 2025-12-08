package GymMerchandiseManagement;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

public class WorkoutGearDAO {

    public void saveNewWorkoutGearToDB(WorkoutGear workoutGear) {

        String sql = "INSERT INTO workoutGear (merchId, name, desc, cost, quantity) VALUES (?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, workoutGear.getMerchId());
            preparedStatement.setString(2, workoutGear.getName());
            preparedStatement.setString(3, workoutGear.getDesc());
            preparedStatement.setDouble(4, workoutGear.getCost());
            preparedStatement.setInt(5, workoutGear.getQuantity());

            Logger.info("Workout Gear saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving Workout Gear to database";
            Logger.error(message + e.getMessage());
        }
    }
}
