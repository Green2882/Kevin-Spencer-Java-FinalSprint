package Users;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;

public class UserDAO {

    public void saveNewUserToDB(User user) {

        String sql = "INSERT INTO users (userName, password, email, phone, address, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getRole());

            Logger.info("User saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving user to database";
            Logger.error(message + e.getMessage());
        }
    }

}
