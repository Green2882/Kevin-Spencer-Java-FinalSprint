package MembershipManagement;

import java.sql.SQLException;
import Users.User;
import Roles.Admin;
import Logger.Logger;

public class MembershipService {

    MembershipDAO membershipDao = new MembershipDAO();

    // Members/Trainers: Purchase membership
    public void saveNewMembership(Membership membership, User user) {
        System.out.println("Saving new membership details: " + membership.getMsType());
        membershipDao.saveNewMembershipToDB(membership, user);
        Logger.info("New membership created for user: " + user.getUserName());
        System.out.println("Membership saved to system!");
    }

    // Admins: View total revenue (placeholder)
    public void viewTotalRevenue() {
        System.out.println("=== MEMBERSHIP REVENUE REPORT ===");
        System.out.println("Feature not yet implemented - requires revenue calculation in DAO");
        Logger.info("Revenue report requested");
    }

    // Admins: Track membership statistics (placeholder)
    public void viewMembershipStatistics() {
        System.out.println("=== MEMBERSHIP STATISTICS ===");
        System.out.println("Feature not yet implemented - requires statistics methods in DAO");
        Logger.info("Membership statistics requested");
    }

}
