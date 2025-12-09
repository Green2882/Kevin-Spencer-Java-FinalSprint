package WorkoutManagement;

import java.sql.SQLException;
import Roles.Trainer;

public class WorkoutClassService {

    WorkoutClassDAO workoutDao = new WorkoutClassDAO();

    public void saveNewWorkoutClass(WorkoutClass workoutclass, Trainer trainer) {
        System.out.println("Saving new workout class: " + workoutclass.getWcType());
        workoutDao.saveNewWorkoutClassToDB(workoutclass, trainer);
    }
}
