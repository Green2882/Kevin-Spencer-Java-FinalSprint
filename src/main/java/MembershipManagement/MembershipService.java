package MembershipManagement;

import java.sql.SQLException;

public class MembershipService {

    MembershipDAO membershipDao = new MembershipDAO();

    public void saveNewMembership(Membership membership) {
        System.out.println("Saving new membership details: " + membership.getMsType);
        membershipDao.saveNewMembershipToDB(membership);
    }

    // public void getMembershipByEmail(String email) throws SQLException {
    //     System.out.println("Getting membership details");
    //     membershipDao.toString(email);
    // }
}
