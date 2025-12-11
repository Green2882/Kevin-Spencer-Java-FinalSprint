package MembershipManagement;

import DatabaseConnection.DatabaseConnection;
import Logger.Logger;
import Users.User;

/**
 * Data Access Object (DAO) for membership management in the gym system.
 * Handles all database operations related to memberships including creating,
 * retrieving membership data, and calculating revenue statistics.
 */
public class MembershipDAO {

    /**
     * Saves a new membership to the database.
     * Associates the membership with the specified user and logs the operation.
     * 
     * @param membership the Membership object containing membership details
     * @param user the User object representing the member purchasing the membership
     */

    public void saveNewMembershipToDB(Membership membership, User user) {

        String sql = "INSERT INTO membership (msType, msDesc, msCost, userId) VALUES (?, ?, ?, ?)";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, membership.getMsType());
            preparedStatement.setString(2, membership.getMsDesc());
            preparedStatement.setDouble(3, membership.getMsCost());
            preparedStatement.setInt(4, user.getUserId());

            preparedStatement.executeUpdate();

            Logger.info("Membership saved to database for user ID: " + user.getUserId());

        } catch (Exception e) {
            Logger.error("Error saving membership to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Calculates the total revenue generated from all memberships.
     * This method is typically used by administrators for financial reporting.
     * 
     * @return the total revenue from all memberships as a double
     */

    public double getTotalRevenue() {
        String sql = "SELECT SUM(msCost) as total_revenue FROM membership";
        double totalRevenue = 0.0;

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalRevenue = resultSet.getDouble("total_revenue");
            }

            Logger.info("Total revenue calculated: $" + totalRevenue);

        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error calculating total revenue: " + e.getMessage());
        }

        return totalRevenue;
    }

    /**
     * Retrieves and displays all memberships from the database.
     * Shows comprehensive membership statistics including ID, type, description,
     * cost, and associated user ID. This method is for administrative use.
     */
    
    public void getAllMemberships() {
        String sql = "SELECT * FROM membership";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            
            System.out.println("Membership Statistics");
            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getInt("msId")
                        + " | Type: " + resultSet.getString("msType")
                        + " | Desc: " + resultSet.getString("msDesc")
                        + " | Cost: $" + resultSet.getDouble("msCost")
                        + " | User ID: " + resultSet.getInt("userId")
                );
            }

            Logger.info("All memberships retrieved");

        } catch (Exception e) {
            Logger.error("Error retrieving memberships: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Calculates the total membership expenses for a specific member.
     * Shows the sum of all membership costs purchased by the specified user.
     * 
     * @param userId the ID of the user whose expenses should be calculated
     * @return the total amount spent by the user on memberships
     */
    public double getMemberTotalExpenses(int userId) {
        String sql = "SELECT SUM(msCost) as total_expenses FROM membership WHERE userId = ?";
        double totalExpenses = 0.0;

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            var resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                totalExpenses = resultSet.getDouble("total_expenses");
            }

            Logger.info("Member expenses calculated for user ID " + userId + ": $" + totalExpenses);

        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error calculating member expenses: " + e.getMessage());
        }

        return totalExpenses;
    }

}
