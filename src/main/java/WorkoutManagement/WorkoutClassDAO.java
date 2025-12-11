package WorkoutManagement;

import java.sql.SQLException;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;
import Roles.Trainer;

/**
 * Data Access Object (DAO) for workout class management in the gym system.
 * Handles all database operations related to workout classes including
 * creating, reading, updating, and deleting workout class records with trainer
 * assignments.
 */
public class WorkoutClassDAO {

    /**
     * Saves a new workout class to the database with trainer assignment.
     * Associates the workout class with the specified trainer and logs the
     * operation.
     *
     * @param workoutclass the WorkoutClass object containing class details
     * @param trainer the Trainer object responsible for conducting this class
     */
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

    /**
     * Retrieves and displays all workout classes from the database. Shows class
     * ID and description for all available workout classes.
     *
     * @param workoutClass currently unused parameter for future functionality
     * @throws SQLException if database query execution fails
     */
    public void printAllWorkoutClasses() throws SQLException {
        String sql = "SELECT * FROM workoutclass";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Class ID: " + resultSet.getString("wcId")
                        + " | Type: " + resultSet.getString("wcType")
                        + " | Desc: " + resultSet.getString("wcDesc")
                        + " | Trainer ID: " + resultSet.getInt("trainerId"));
            }
        }
    }

    /**
     * Retrieves and displays workout classes assigned to a specific trainer.
     * Shows class ID and description for classes assigned to the trainer.
     *
     * @param workoutClass currently unused parameter for future functionality
     * @throws SQLException if database query execution fails
     */
    public void printAllAssignedWorkoutClasses() throws SQLException {
        String sql = "SELECT * FROM workoutclass WHERE trainerId = ?";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(" Class ID: " + resultSet.getString("wcId") + " Class Description: " + resultSet.getString("wcDesc"));
            }
        }
    }

    /**
     * Retrieves and displays workout classes available to a specific member.
     * Shows class ID and description for classes accessible by membership.
     *
     * @param workoutClass currently unused parameter for future functionality
     * @throws SQLException if database query execution fails
     */
    public void printAllAssignedMemberWorkoutClasses(WorkoutClass workoutClass) throws SQLException {
        String sql = "SELECT * FROM workoutclass WHERE msId = ?";
        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Class ID: " + resultSet.getString("wcId")
                        + " | Type: " + resultSet.getString("wcType")
                        + " | Desc: " + resultSet.getString("wcDesc")
                        + " | Trainer ID: " + resultSet.getInt("trainerId"));
            }
        }
    }

    /**
     * Updates an existing workout class in the database. Allows trainers to
     * modify workout class type and description. Provides feedback on operation
     * success or failure.
     *
     * @param workoutClass the WorkoutClass object with updated information
     */
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

    /**
     * Deletes a workout class from the database. Allows trainers to remove
     * workout classes they are responsible for. Provides feedback on operation
     * success or failure.
     *
     * @param wcId the unique identifier of the workout class to delete
     */
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
