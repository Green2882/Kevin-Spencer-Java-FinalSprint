package Users;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import Logger.Logger;

public class UserService {

    UserDAO userDAO = new UserDAO();

    // Save new user to DB
    public void saveNewUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(8));
        user.setPassword(hashedPassword);

        userDAO.saveNewUserToDB(user);

        Logger.info("New user registered: " + user.getUserName());
        System.out.println("User saved to system!");
    }

    // Verify username
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    // Verify password
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    // User login
    public User userLogIn(String userName, String password) {

        try {
            User user = getUserByUsername(userName);

            if (user == null) {
                Logger.error("Login failed: user not found: " + userName);
                System.out.println("Invalid credentials!");
                return null;
            }

            if (verifyPassword(password, user.getPassword())) {
                Logger.info("User logged in: " + userName);
                System.out.println("Login successful!");
                return user;
            } else {
                Logger.error("Login failed: incorrect password for: " + userName);
                System.out.println("Invalid credentials!");
                return null;
            }

        } catch (Exception e) {
            Logger.error("Login error for '" + userName + "': " + e.getMessage());
            System.out.println("Invalid credentials!");
            return null;
        }
    }

    // Get user by ID
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    // Get all users in system
    public ArrayList<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // Delete user by ID
    public boolean deleteUserById(int id) {
        return userDAO.deleteUserById(id);
    }

    // Role based login checks
    public boolean isAdmin(User user) {
        return user.getRole().equalsIgnoreCase("admin");
    }

    public boolean isTrainer(User user) {
        return user.getRole().equalsIgnoreCase("trainer");
    }

    public boolean isMember(User user) {
        return user.getRole().equalsIgnoreCase("member");
    }

    // Check if username exists
    public boolean usernameExists(String username) {
        return userDAO.getUserByUsername(username) != null;
    }

    // Allow user to logout
    public void logout(User user) {
        Logger.info("User logged out: " + user.getUserName());
    }

}
