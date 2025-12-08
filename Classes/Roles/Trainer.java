package Roles;

public class Trainer extends Users.User {

    // Instnace variables
    private String trainerId;

    // Constructor
    public Trainer(String userName, String password, String email, String phone, String role, int userId, String trainerId) {
        super(userName, password, email, phone, role, userId);
        this.trainerId = trainerId;
    }

    public Trainer() {
    }

    // Getters and Setters
    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    // toString method  
    @Override
    public String toString() {
        return "Trainer{" + super.toString() + ", trainerId=" + trainerId + '}';
    }

}
