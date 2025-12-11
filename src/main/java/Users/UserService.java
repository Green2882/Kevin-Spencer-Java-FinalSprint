package Users;

import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

import Logger.Logger;

/**
 * The UserService class provides operations for managing users, including
 * registration, authentication, role checking, retrieval, and deletion. It
 * interacts with the UserDAO for all database-related tasks.
 */
public class UserService {

    UserDAO userDAO = new UserDAO();

    /**
     * Saves a new user to the system. The method hashes the user's password
     * using BCrypt before saving the user to the database through the UserDAO.
     * Once saved, a confirmation message is logged and displayed.
     *
     * @param user the User object to be saved
     */
    public void saveNewUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(8));
        user.setPassword(hashedPassword);

        userDAO.saveNewUserToDB(user);

        Logger.info("New user registered: " + user.getUserName());
        System.out.println("User saved to system!");
    }

    /**
     * Retrieves a user from the system based on their username.
     *
     * @param username the username of the user to retrieve
     * @return a User object if found, or null if no such user exists
     */
    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    /**
     * Verifies whether a provided plain-text password matches its hashed
     * version stored in the database. BCrypt is used for secure comparison.
     *
     * @param plainPassword the password entered by the user
     * @param hashedPassword the hashed password stored in the database
     * @return true if the password matches, false otherwise
     */
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    /**
     * Attempts to authenticate a user using their username and password. The
     * method retrieves the user, checks if the password matches using BCrypt,
     * and logs the result. If authentication succeeds, the corresponding User
     * object is returned.
     *
     * @param userName the username entered during login
     * @param password the plain-text password entered during login
     * @return the authenticated User object if credentials are valid, otherwise
     * null
     */
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

    /**
     * Retrieves a user from the system based on their user ID.
     *
     * @param id the unique ID of the user
     * @return a User object if found, or null otherwise
     */
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    /**
     * Retrieves all users stored in the system.
     *
     * @return an ArrayList containing all User objects
     */
    public ArrayList<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    /**
     * Deletes a user from the system based on their user ID.
     *
     * @param id the unique ID of the user to delete
     * @return true if the user was successfully deleted, false otherwise
     */
    public boolean deleteUserById(int id) {
        return userDAO.deleteUserById(id);
    }

    /**
     * Checks whether the given user has the admin role.
     *
     * @param user the user to check
     * @return true if the user is an admin, false otherwise
     */
    public boolean isAdmin(User user) {
        return user.getRole().equalsIgnoreCase("admin");
    }

    /**
     * Checks whether the given user has the trainer role.
     *
     * @param user the user to check
     * @return true if the user is a trainer, false otherwise
     */
    public boolean isTrainer(User user) {
        return user.getRole().equalsIgnoreCase("trainer");
    }

    /**
     * Checks whether the given user has the member role.
     *
     * @param user the user to check
     * @return true if the user is a member, false otherwise
     */
    public boolean isMember(User user) {
        return user.getRole().equalsIgnoreCase("member");
    }

    /**
     * Checks whether a username already exists in the system.
     *
     * @param username the username to check
     * @return true if the username is already registered, false otherwise
     */
    public boolean usernameExists(String username) {
        return userDAO.getUserByUsername(username) != null;
    }

    /**
     * Logs out the specified user.
     *
     * @param user the user who is logging out
     */
    public void logout(User user) {
        Logger.info("User logged out: " + user.getUserName());
    }

}
