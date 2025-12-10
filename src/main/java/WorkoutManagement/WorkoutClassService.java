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
            System.out.println("Available Workout Classes");
            workoutDao.printAllWorkoutClasses();
            Logger.info("Workout classes viewed");
        } catch (SQLException e) {
            Logger.error("Error viewing workout classes: " + e.getMessage());
            System.out.println("Error retrieving workout classes.");
        }
    }

    // Members & Trainers: View assigned classes
    public void viewAllAssignedWorkoutClasses(Trainer trainer) {
        try {
            System.out.println("Assigned Workout Classes");
            workoutDao.printAllAssignedWorkoutClasses(trainer.getTrainerId());
            Logger.info("Current workout classes viewed");
        } catch (SQLException e) {
            Logger.error("Error viewing workout classes: " + e.getMessage());
            System.out.println("Error retrieving workout classes.");
        }
    }

    // Trainers: Update workout class
    public void updateWorkoutClass(WorkoutClass workoutClass) {
        System.out.println("Updating workout class: " + workoutClass.getWcId());
        workoutDao.updateWorkoutClass(workoutClass);
        Logger.info("Workout class update completed for: " + workoutClass.getWcId());
    }

    // Trainers: Delete workout class
    public void deleteWorkoutClass(String wcId) {
        System.out.println("Deleting workout class: " + wcId);
        workoutDao.deleteWorkoutClass(wcId);
        Logger.info("Workout class deletion completed for: " + wcId);
    }

}
