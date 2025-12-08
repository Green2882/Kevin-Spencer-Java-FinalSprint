package Users;

public class User {

    // Instance variables
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String role;

    // Constructors
    public User(String userName, String password, String email, String phone, String role, int userId) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public User() {
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // toString method
    @Override
    public String toString() {
        return "User{"
                + ", userName='" + userName + '\''
                + ", password='" + password + '\''
                + ", email='" + email + '\''
                + ", phone='" + phone + '\''
                + ", role='" + role + '\''
                + '}';
    }
}
