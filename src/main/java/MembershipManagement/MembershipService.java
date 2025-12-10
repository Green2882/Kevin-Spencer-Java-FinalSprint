package MembershipManagement;

import Logger.Logger;
import Users.User;

public class MembershipService {

    MembershipDAO membershipDao = new MembershipDAO();

    // Members/Trainers: Purchase membership
    public void saveNewMembership(Membership membership, User user) {
        System.out.println("Saving new membership details: " + membership.getMsType());
        membershipDao.saveNewMembershipToDB(membership, user);
        Logger.info("New membership created for user: " + user.getUserName());
        System.out.println("Membership saved to system!");
    }

    // Admins: View total revenue
    public void viewTotalRevenue() {
        System.out.println("Membership Revenue Report");
        double totalRevenue = membershipDao.getTotalRevenue();
        System.out.println("Total Revenue: $" + String.format("%.2f", totalRevenue));
        Logger.info("Revenue report displayed: $" + totalRevenue);
    }

    // Admins: Track membership statistics
    public void viewAllmemberships() {
        membershipDao.getAllMemberships();
        Logger.info("Membership statistics displayed");
    }

}
