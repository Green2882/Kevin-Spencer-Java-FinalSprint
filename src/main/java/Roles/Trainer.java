package Roles;

/**
 * The Trainer class represents a gym trainer within the gym management system.
 * It extends the User class, inheriting all standard user fields such as
 * username, password, email, phone, address, and role. Trainers also include a
 * trainer-specific ID.
 */
public class Trainer extends Users.User {

    // Instance variables
    private int trainerId;

    /**
     * Constructs a new Trainer object with all user and trainer-specific
     * fields.
     *
     * @param userName the username chosen by the trainer
     * @param password the trainer's account password
     * @param email the trainer's email address
     * @param phone the trainer's phone number
     * @param address the trainer's address
     * @param role the role assigned to this user (expected to be "trainer")
     * @param userId the unique ID assigned to the trainer as a user
     * @param trainerId the unique trainer-specific ID used for training
     * assignments
     */
    public Trainer(String userName, String password, String email, String phone, String address, String role, int userId, int trainerId) {
        super(userName, password, email, phone, address, role, userId);
        this.trainerId = trainerId;
    }

    public Trainer() {
    }

    /**
     * Returns the trainer-specific ID for this trainer.
     *
     * @return the trainer ID as an integer
     */
    public int getTrainerId() {
        return trainerId;
    }

    /**
     * Sets a new trainer ID for this trainer.
     *
     * @param trainerId the new trainer-specific ID
     */
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * Returns a string representation of the Trainer object, including the
     * inherited user fields and the trainer-specific ID.
     *
     * @return formatted Trainer details as a String
     */
    @Override
    public String toString() {
        return "Trainer{" + super.toString() + ", trainerId=" + trainerId + '}';
    }
}
