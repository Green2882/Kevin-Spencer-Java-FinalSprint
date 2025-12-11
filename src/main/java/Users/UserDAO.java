package Users;

import java.sql.Statement;
import java.util.ArrayList;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;
import Roles.Admin;
import Roles.Member;
import Roles.Trainer;

/**
 * The userDAO class allows the program to connect to the users table in pgAdmin
 * for creating, reading, updating, and deleting data
 *
 */
public class UserDAO {

    /**
     * Saves a new User object to the database. The method inserts the user's
     * username, password, email, phone, address, and role into the users table.
     * After insertion, the database-generated user ID is retrieved and assigned
     * back to the User object.
     *
     * @param user the User object to be saved to the database
     */
    public void saveNewUserToDB(User user) {

        String sql = "INSERT INTO users (userName, password, email, phone, address, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon(); var preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.executeUpdate();

            try (var keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {
                    user.setUserId(keys.getInt(1));
                }
            }

            Logger.info("User saved to database: " + user.getUserName());

        } catch (Exception e) {
            Logger.error("Error saving user '" + user.getUserName() + "' to DB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Retrieves a user from the database based on their username. The method
     * looks up the user in the users table and returns a User object of the
     * correct subclass (Admin, Trainer, Member) depending on the user's role.
     * If no matching username is found, the method returns null.
     *
     * @param username the username of the user to retrieve
     * @return a User object representing the retrieved user, or null if not
     * found
     */
    public User getUserByUsername(String username) {

        String sql = "SELECT * FROM users WHERE userName = ?";
        User user = null;

        try (var connection = DatabaseConnection.getCon(); var preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username);

            try (var resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {

                    String role = resultSet.getString("role");
                    int userId = resultSet.getInt("userId");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    String password = resultSet.getString("password");

                    // RETURN CORRECT OBJECT TYPE BASED ON ROLE
                    switch (role.toLowerCase()) {

                        case "trainer":
                            Trainer trainer = new Trainer();
                            trainer.setUserId(userId);
                            trainer.setUserName(username);
                            trainer.setPassword(password);
                            trainer.setEmail(email);
                            trainer.setPhone(phone);
                            trainer.setAddress(address);
                            trainer.setRole(role);

                            // If trainerId == userId
                            trainer.setTrainerId(userId);

                            user = trainer;
                            break;

                        case "admin":
                            Admin admin = new Admin();
                            admin.setUserId(userId);
                            admin.setUserName(username);
                            admin.setPassword(password);
                            admin.setEmail(email);
                            admin.setPhone(phone);
                            admin.setAddress(address);
                            admin.setRole(role);
                            user = admin;
                            break;

                        case "member":
                            Member member = new Member();
                            member.setUserId(userId);
                            member.setUserName(username);
                            member.setPassword(password);
                            member.setEmail(email);
                            member.setPhone(phone);
                            member.setAddress(address);
                            member.setRole(role);
                            user = member;
                            break;

                        default:
                            user = new User();
                            user.setUserId(userId);
                            user.setUserName(username);
                            user.setPassword(password);
                            user.setEmail(email);
                            user.setPhone(phone);
                            user.setAddress(address);
                            user.setRole(role);
                            break;
                    }

                    Logger.info("User retrieved from DB: " + username);
                } else {
                    Logger.error("User not found in DB: " + username);
                }
            }

        } catch (Exception e) {
            Logger.error("Error retrieving user '" + username + "' from DB: " + e.getMessage());
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Retrieves a user from the database based on their user ID. The method
     * queries the users table using the provided ID, and returns a User object
     * of the correct subclass (Admin, Trainer, Member) depending on the user's
     * role. If no user with the given ID exists, the method returns null.
     *
     * @param id the unique ID of the user to retrieve
     * @return a User object representing the retrieved user, or null if not
     * found
     */
    public User getUserById(int id) {

        String sql = "SELECT * FROM users WHERE userId = ?";
        User user = null;

        try (var connection = DatabaseConnection.getCon(); var preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);

            try (var resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {

                    String username = resultSet.getString("userName");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    String role = resultSet.getString("role");
                    int userId = resultSet.getInt("userId");

                    switch (role.toLowerCase()) {

                        case "trainer":
                            Trainer trainer = new Trainer();
                            trainer.setUserId(userId);
                            trainer.setUserName(username);
                            trainer.setPassword(password);
                            trainer.setEmail(email);
                            trainer.setPhone(phone);
                            trainer.setAddress(address);
                            trainer.setRole(role);
                            trainer.setTrainerId(userId);
                            user = trainer;
                            break;

                        case "admin":
                            Admin admin = new Admin();
                            admin.setUserId(userId);
                            admin.setUserName(username);
                            admin.setPassword(password);
                            admin.setEmail(email);
                            admin.setPhone(phone);
                            admin.setAddress(address);
                            admin.setRole(role);
                            user = admin;
                            break;

                        case "member":
                            Member member = new Member();
                            member.setUserId(userId);
                            member.setUserName(username);
                            member.setPassword(password);
                            member.setEmail(email);
                            member.setPhone(phone);
                            member.setAddress(address);
                            member.setRole(role);
                            user = member;
                            break;

                        default:
                            user = new User();
                            user.setUserId(userId);
                            user.setUserName(username);
                            user.setPassword(password);
                            user.setEmail(email);
                            user.setPhone(phone);
                            user.setAddress(address);
                            user.setRole(role);
                            break;
                    }

                    Logger.info("User retrieved from DB by ID: " + id);
                } else {
                    Logger.error("User not found in DB by ID: " + id);
                }
            }

        } catch (Exception e) {
            Logger.error("Error retrieving user by ID '" + id + "': " + e.getMessage());
            e.printStackTrace();
        }

        return user;
    }

    /**
     * Retrieves all users stored in the database. The method queries the users
     * table and returns an ArrayList containing User objects for each record
     * found. This method is typically used by administrators to view all
     * registered users.
     *
     * @return an ArrayList of User objects representing all users in the system
     */
    public ArrayList<User> getAllUsers() {

        String sql = "SELECT * FROM users";
        ArrayList<User> users = new ArrayList<>();

        try (var connection = DatabaseConnection.getCon(); var preparedStatement = connection.prepareStatement(sql); var resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();

                user.setUserId(resultSet.getInt("userId"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setRole(resultSet.getString("role"));

                users.add(user);
            }

            Logger.info("All users retrieved from DB.");

        } catch (Exception e) {
            Logger.error("Error retrieving all users from DB: " + e.getMessage());
            e.printStackTrace();
        }

        return users;
    }

    /**
     * Deletes a user from the database based on their user ID. The method
     * attempts to remove the user with the specified ID from the users table.
     * If the deletion is successful, it returns true. If no matching user is
     * found or an error occurs, it returns false.
     *
     * @param id the unique ID of the user to delete
     * @return true if the user was successfully deleted, false otherwise
     */
    public boolean deleteUserById(int id) {

        String sql = "DELETE FROM users WHERE userId = ?";

        try (var connection = DatabaseConnection.getCon(); var preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Logger.info("User deleted from DB by ID: " + id);
                return true;
            } else {
                Logger.error("No user found to delete with ID: " + id);
                return false;
            }

        } catch (Exception e) {
            Logger.error("Error deleting user by ID '" + id + "': " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
