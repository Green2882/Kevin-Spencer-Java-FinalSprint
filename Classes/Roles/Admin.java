package Roles;

public class Admin extends Users.User {

    // Constructor
    public Admin(String userName, String password, String email, String phone, String role, int userId) {
        super(userName, password, email, phone, role, userId);
    }

    public Admin() {
    }

    // toString method  
    @Override
    public String toString() {
        return "Admin{" + super.toString() + '}';
    }
}
