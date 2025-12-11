package Roles;

/**
 * The Member class represents a standard gym member within the gym management
 * system. It extends the User class and inherits all user details such as
 * username, password, email, phone, address, and role.
 */
public class Member extends Users.User {

    /**
     * Constructs a new Member object with all user-related fields.
     *
     * @param userName the username chosen by the member
     * @param password the member's account password
     * @param email the member's email address
     * @param phone the member's phone number
     * @param address the member's address
     * @param role the role assigned to this user (expected to be "member")
     * @param userId the unique ID assigned to the member
     */
    public Member(String userName, String password, String email, String phone, String address, String role, int userId) {
        super(userName, password, email, phone, address, role, userId);
    }

    public Member() {
    }

    /**
     * Returns a string representation of the Member object.
     *
     * @return formatted Member details as a String
     */
    @Override
    public String toString() {
        return "Member{" + super.toString() + '}';
    }
}
