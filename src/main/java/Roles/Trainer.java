package Roles;

public class Trainer extends Users.User {

    // Instnace variables
    private int trainerId;

    // Constructor
    public Trainer(String userName, String password, String email, String phone, String address, String role, int userId, int trainerId) {
        super(userName, password, email, phone, address, role, userId);
        this.trainerId = userId;
    }

    public Trainer() {
    }

    // Getters and Setters
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int userId) {
        this.trainerId = userId;
    }

    // toString method  
    @Override
    public String toString() {
        return "Trainer{" + super.toString() + ", trainerId=" + trainerId + '}';
    }

}
