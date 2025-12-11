package WorkoutManagement;

import java.sql.SQLException;

import Logger.Logger;
import Roles.Trainer;

/**
 * Service layer for workout class management in the gym system.
 * Provides business logic operations for workout class processing including
 * class creation, viewing, updating, and deletion with role-based access control.
 */
public class WorkoutClassService {

    WorkoutClassDAO workoutDao = new WorkoutClassDAO();

    /**
     * Processes creation of a new workout class for trainers.
     * Saves the workout class to the database and provides user feedback.
     * 
     * @param workoutclass the WorkoutClass object containing class details
     * @param trainer the Trainer object responsible for the class
     */

    public void saveNewWorkoutClass(WorkoutClass workoutclass, Trainer trainer) {
        System.out.println("Saving new workout class: " + workoutclass.getWcType());
        workoutDao.saveNewWorkoutClassToDB(workoutclass, trainer);
        Logger.info("New workout created.");
        System.out.println("Workout class saved to system!");
    }

    /**
     * Displays all available workout classes for members.
     * Shows comprehensive listing of all workout classes in the system.
     * Includes error handling for improved user experience.
     */

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

    /**
     * Displays workout classes available to a specific member.
     * Shows classes accessible based on member's membership level.
     * Includes error handling for improved user experience.
     */

    public void viewAllAssignedMemberWorkoutClasses() {
        try {
            System.out.println("Available Workout Classes");
            workoutDao.printAllAssignedMemberWorkoutClasses(null);
            Logger.info("Workout classes viewed");
        } catch (SQLException e) {
            Logger.error("Error viewing workout classes: " + e.getMessage());
            System.out.println("Error retrieving workout classes.");
        }
    }


    /**
     * Displays workout classes assigned to a specific trainer.
     * Shows classes that the trainer is responsible for conducting.
     * Includes error handling for improved user experience.
     * 
     * @param trainer the Trainer object whose assigned classes should be displayed
     */
    public void viewAllAssignedWorkoutClasses(Trainer trainer) {
        try {
            System.out.println("Assigned Workout Classes");
            workoutDao.printAllAssignedWorkoutClasses(trainer);
            Logger.info("Current workout classes viewed");
        } catch (SQLException e) {
            Logger.error("Error viewing workout classes: " + e.getMessage());
            System.out.println("Error retrieving workout classes.");
        }
    }

    /**
     * Processes workout class updates for trainers.
     * Allows trainers to modify their assigned workout classes.
     * 
     * @param workoutClass the WorkoutClass object with updated information
     */

    public void updateWorkoutClass(WorkoutClass workoutClass) {
        System.out.println("Updating workout class: " + workoutClass.getWcId());
        workoutDao.updateWorkoutClass(workoutClass);
        Logger.info("Workout class update completed for: " + workoutClass.getWcId());
    }

    /**
     * Processes workout class deletion for trainers.
     * Allows trainers to remove workout classes they are responsible for.
     * 
     * @param wcId the unique identifier of the workout class to delete
     */
    
    public void deleteWorkoutClass(int wcId) {
        System.out.println("Deleting workout class: " + wcId);
        workoutDao.deleteWorkoutClass(wcId);
        Logger.info("Workout class deletion completed for: " + wcId);
    }

}
