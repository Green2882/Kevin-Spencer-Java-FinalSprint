package MembershipManagement;

import Logger.Logger;
import Users.User;

/**
 * Service layer for membership management in the gym system.
 * Provides business logic operations for membership processing including
 * membership creation, revenue reporting, and administrative statistics
 * with role-based access control.
 */
public class MembershipService {

    MembershipDAO membershipDao = new MembershipDAO();

    /**
     * Processes a new membership purchase for members and trainers.
     * Saves the membership to the database and provides user feedback.
     * 
     * @param membership the Membership object containing membership details
     * @param user the User object representing the purchaser
     */

    public void saveNewMembership(Membership membership, User user) {
        System.out.println("Saving new membership details: " + membership.getMsType());
        membershipDao.saveNewMembershipToDB(membership, user);
        Logger.info("New membership created for user: " + user.getUserName());
        System.out.println("Membership saved to system!");
    }

    /**
     * Displays total revenue report for administrators.
     * Calculates and presents formatted revenue information from all memberships.
     * This operation is restricted to administrative users.
     */

    public void viewTotalRevenue() {
        System.out.println("Membership Revenue Report");
        double totalRevenue = membershipDao.getTotalRevenue();
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
        Logger.info("Revenue report displayed: $" + totalRevenue);
    }

    /**
     * Displays comprehensive membership statistics for administrators.
     * Shows detailed information about all memberships in the system
     * including membership details and associated users.
     */
    
    public void viewAllmemberships() {
        membershipDao.getAllMemberships();
        Logger.info("Membership statistics displayed");
    }

}
