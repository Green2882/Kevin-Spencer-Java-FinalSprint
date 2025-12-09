package WorkoutManagement;

import java.sql.SQLException;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;
import Roles.Trainer;

public class WorkoutClassDAO {

    public void saveNewWorkoutClassToDB(WorkoutClass workoutclass, Trainer trainer) {

        String sql = "INSERT INTO workoutclass (wcId, wcType, wcDesc, trainerId) VALUES (?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, workoutclass.getWcId());
            preparedStatement.setString(2, workoutclass.getWcType());
            preparedStatement.setString(3, workoutclass.getWcDesc());
            preparedStatement.setInt(4, trainer.getTrainerId());
            preparedStatement.executeUpdate();

            Logger.info("Workout Class saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving Workout Class to database";
            Logger.error(message + e.getMessage());
        }
    }

    public void printAllWorkoutClasses(WorkoutClass workoutClass) throws SQLException {
        String sql = "SELECT * FROM workoutclass";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Class ID: " + resultSet.getString("wcId") + " Class Description: " + resultSet.getString("wcDesc"));
            }
        }
    }
}
