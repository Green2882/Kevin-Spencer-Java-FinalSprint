package MembershipManagement;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;
import Users.User;

public class MembershipDAO {

    public void saveNewMembershipToDB(Membership membership, User user) {

        String sql = "INSERT INTO membership (msId, msType, msDesc, msCost, userId) VALUES (?, ?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, membership.getMsId());
            preparedStatement.setString(2, membership.getMsType());
            preparedStatement.setString(3, membership.getMsDesc());
            preparedStatement.setDouble(4, membership.getMsCost());
            preparedStatement.setInt(5, user.getUserId());
            preparedStatement.executeUpdate();

            Logger.info("Membership saved to database");

        } catch (Exception e) {
            e.printStackTrace();
            String message = "Error saving membership to database";
            Logger.error(message + e.getMessage());
        }
    }
}