package MembershipManagement;

import java.sql.SQLException;
import Users.User;

public class MembershipService {

    MembershipDAO membershipDao = new MembershipDAO();

    public void createNewMember(Membership membership, User user) {
        System.out.println("Creating membership " 
        + membership.getMsType() + " to user " 
        + user.getUserName());

        membershipDao.saveNewMembershipToDB(membership, user);
    }

    public void saveNewMembership(Membership membership, User user) {
        System.out.println("Saving new membership details: " + membership.getMsType());
        membershipDao.saveNewMembershipToDB(membership, user);
    }

    // public void getMembershipByEmail(String email) throws SQLException {
    //     System.out.println("Getting membership details");
    //     membershipDao.toString(email);
    // }
}
