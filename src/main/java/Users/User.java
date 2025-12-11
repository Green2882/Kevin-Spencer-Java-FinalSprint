package Users;

/**
 * The User class represents a user in the gym management system. It includes
 * details such as ID, username, password, email, phone, address, and role.
 */
public class User {

    // Instance variables
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String role;

    // Constructors
    /**
     * Constructs a new User object with all details, including user ID.
     *
     * @param userName the username chosen by the user
     * @param password the user's account password
     * @param email the user's email address
     * @param phone the user's phone number
     * @param address the user's address
     * @param role the role assigned to the user (e.g., Member, Admin, Trainer)
     * @param userId the unique ID assigned to the user
     */
    public User(String userName, String password, String email, String phone, String address, String role, int userId) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.userId = userId;
    }

    /**
     * Constructs a new User object without a user ID.
     *
     * @param userName the username chosen by the user
     * @param password the user's account password
     * @param email the user's email address
     * @param phone the user's phone number
     * @param address the user's address
     * @param role the role assigned to the user
     */
    public User(String userName, String password, String email, String phone, String address, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    /**
     * Default constructor for creating an empty User object.
     */
    public User() {
    }

    // Getters and Setters
    /**
     * Returns the user's unique ID.
     *
     * @return the user ID as an integer
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets a new user ID.
     *
     * @param userId the new ID for the user
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username as a String
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets a new username for the user.
     *
     * @param userName the new username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password as a String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets a new password for the user.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email of the user.
     *
     * @return the email as a String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets a new email for the user.
     *
     * @param email the new email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the phone number of the user.
     *
     * @return the phone number as a String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets a new phone number for the user.
     *
     * @param phone the new phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns the address of the user.
     *
     * @return the address as a String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets a new address for the user.
     *
     * @param address the new address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the role of the user.
     *
     * @return the user's role as a String
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets a new role for the user.
     *
     * @param role the new role (e.g., Member, Admin, Trainer)
     */
    public void setRole(String role) {
        this.role = role;
    }

    // toString method
    /**
     * Returns a string representation of the User object.
     *
     * @return formatted user details as a String
     */
    @Override
    public String toString() {
        return "User{"
                + "userId=" + userId
                + ", userName='" + userName + '\''
                + ", password='" + password + '\''
                + ", email='" + email + '\''
                + ", phone='" + phone + '\''
                + ", address='" + address + '\''
                + ", role='" + role + '\''
                + '}';
    }
}
