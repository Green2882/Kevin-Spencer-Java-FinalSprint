package WorkoutManagement;

import java.sql.SQLException;

import Logger.Logger;
import Roles.Trainer;

public class WorkoutClassService {

    WorkoutClassDAO workoutDao = new WorkoutClassDAO();

    // Trainers: Add new workout class
    public void saveNewWorkoutClass(WorkoutClass workoutclass, Trainer trainer) {
        System.out.println("Saving new workout class: " + workoutclass.getWcType());
        workoutDao.saveNewWorkoutClassToDB(workoutclass, trainer);
        Logger.info("New workout created.");
        System.out.println("Workout class saved to system!");
    }

    // Members: View all workout classes
    public void viewAllWorkoutClasses() {
        try {
            System.out.println("=== AVAILABLE WORKOUT CLASSES ===");
            workoutDao.printAllWorkoutClasses(null);
            Logger.info("Workout classes viewed");
        } catch (SQLException e) {
            Logger.error("Error viewing workout classes: " + e.getMessage());
            System.out.println("Error retrieving workout classes.");
        }
    }

    // Trainers: Update workout class (placeholder)
    public void updateWorkoutClass(WorkoutClass workoutClass) {
        System.out.println("Update workout class feature not yet implemented");
        Logger.info("Workout class update requested for: " + workoutClass.getWcId());
    }

    // Trainers: Delete workout class (placeholder)
    public void deleteWorkoutClass(String wcId) {
        System.out.println("Delete workout class feature not yet implemented");
        Logger.info("Workout class deletion requested for: " + wcId);
    }

}
