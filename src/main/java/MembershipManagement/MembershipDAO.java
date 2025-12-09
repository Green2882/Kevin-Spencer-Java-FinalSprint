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

    // Admin: Calculate total revenue from memberships
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

    // Admin: Get membership statistics
    public void getMembershipStatistics() {
        String sql = "SELECT msType, COUNT(*) as count, AVG(msCost) as avg_cost FROM membership GROUP BY msType";

        try (var connection = DatabaseConnection.getCon()) {
            var preparedStatement = connection.prepareStatement(sql);
            var resultSet = preparedStatement.executeQuery();
            
            System.out.println("=== MEMBERSHIP STATISTICS ===");
            while (resultSet.next()) {
                System.out.println("Type: " + resultSet.getString("msType") + 
                    " | Count: " + resultSet.getInt("count") + 
                    " | Avg Cost: $" + String.format("%.2f", resultSet.getDouble("avg_cost")));
            }
            
            Logger.info("Membership statistics displayed");

        } catch (Exception e) {
            e.printStackTrace();
            Logger.error("Error retrieving membership statistics: " + e.getMessage());
        }
    }
}