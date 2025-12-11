package Roles;

/**
 * The Admin class represents an administrative user within the gym management
 * system. It extends the User class and inherits all user properties such as
 * username, password, email, phone, address, and role.
 */
public class Admin extends Users.User {

    /**
     * Constructs a new Admin object with all user-related fields.
     *
     * @param userName the username chosen by the admin
     * @param password the admin's account password
     * @param email the admin's email address
     * @param phone the admin's phone number
     * @param address the admin's address
     * @param role the role assigned to this user (expected to be "admin")
     * @param userId the unique ID assigned to the admin
     */
    public Admin(String userName, String password, String email, String phone, String address, String role, int userId) {
        super(userName, password, email, phone, address, role, userId);
    }

    public Admin() {
    }

    /**
     * Returns a string representation of the Admin object.
     *
     * @return formatted Admin details as a String
     */
    @Override
    public String toString() {
        return "Admin{" + super.toString() + '}';
    }
}
