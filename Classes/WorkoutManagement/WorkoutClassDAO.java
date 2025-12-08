package WorkoutManagement;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;
import Roles.Trainer;

public class WorkoutClassDAO {

    public void saveNewMembershipToDB(WorkoutClass workoutclass, Trainer trainer) {

        String sql = "INSERT INTO membership (wcId, wcType, wcDesc, trainerId) VALUES (?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, workoutclass.getWcId());
            preparedStatement.setString(2, workoutclass.getWcType());
            preparedStatement.setString(3, workoutclass.getWcDesc());
            preparedStatement.setString(4, trainer.getTrainerId());

            Logger.info("Workout Class saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving Workout Class to database";
            Logger.error(message + e.getMessage());
        }
    }
}