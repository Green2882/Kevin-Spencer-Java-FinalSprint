package WorkoutManagement;

public class WorkoutClass {
    private String wcId; // WorkoutClass ID
    private String wcType; // WorkoutClass Type
    private String wcDesc; // WorkoutClass Description
    private String trainerId; //Trainer ID

    public WorkoutClass(String wcId, String wcType, String wcDesc, String trainerId) {
        this.wcId = wcId;
        this.wcType = wcType;
        this.wcDesc = wcDesc;
        this.trainerId = trainerId;
    }

    public WorkoutClass() {
    }

    public String getWcId() {
        return wcId;
    }

    public void setWcId(String wcId) {
        this.wcId = wcId;
    }

    public String getWcType() {
        return wcType;
    }

    public void setWcType(String wcType) {
        this.wcType = wcType;
    }

    public String getWcDesc() {
        return wcDesc;
    }

    public void setWcDesc(String wcDesc) {
        this.wcDesc = wcDesc;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

}
