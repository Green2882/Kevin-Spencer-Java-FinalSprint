package WorkoutManagement;

import java.sql.SQLException;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;
import Roles.Trainer;

public class WorkoutClassDAO {

    public void saveNewWorkoutClassToDB(WorkoutClass workoutclass, Trainer trainer) {

        String sql = "INSERT INTO workoutclass (wcType, wcDesc, trainerId) VALUES (?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, workoutclass.getWcType());
            preparedStatement.setString(2, workoutclass.getWcDesc());
            preparedStatement.setInt(3, trainer.getTrainerId());

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
                System.out.println(" Class ID: " + resultSet.getString("wcId") + " Class Description: " + resultSet.getString("wcDesc"));
            }
        }
    }

    // View assigned classes
    public void printAllAssignedWorkoutClasses(WorkoutClass workoutClass) throws SQLException {
        String sql = "SELECT * FROM workoutclass WHERE trainerId = ?";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(" Class ID: " + resultSet.getString("wcId") + " Class Description: " + resultSet.getString("wcDesc"));
            }
        }
    }
    
    public void printAllAssignedMemberWorkoutClasses(WorkoutClass workoutClass) throws SQLException {
        String sql = "SELECT * FROM workoutclass WHERE msId = ?";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(" Class ID: " + resultSet.getString("wcId") + " Class Description: " + resultSet.getString("wcDesc"));
            }
        }
    }

    // Trainer: Update workout class
    public void updateWorkoutClass(WorkoutClass workoutClass) {
        String sql = "UPDATE workoutclass SET wcType = ?, wcDesc = ? WHERE wcId = ?";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, workoutClass.getWcType());
            preparedStatement.setString(2, workoutClass.getWcDesc());
            preparedStatement.setString(3, workoutClass.getWcId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Logger.info("Workout Class updated: " + workoutClass.getWcId());
                System.out.println("Workout class updated successfully!");
            } else {
                Logger.error("No workout class found with ID: " + workoutClass.getWcId());
                System.out.println("Workout class not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error updating Workout Class: " + e.getMessage());
        }
    }

    // Trainer: Delete workout class
    public void deleteWorkoutClass(String wcId) {
        String sql = "DELETE FROM workoutclass WHERE wcId = ?";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, wcId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Logger.info("Workout Class deleted: " + wcId);
                System.out.println("Workout class deleted successfully!");
            } else {
                Logger.error("No workout class found with ID: " + wcId);
                System.out.println("Workout class not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error deleting Workout Class: " + e.getMessage());
        }
    }
}
