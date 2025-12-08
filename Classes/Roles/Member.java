package Roles;

public class Member extends Users.User {
    public Member(String userName, String password, String email, String phone, String role, int userId) {
        super(userName, password, email, phone, role, userId);
    }

    public Member() {

    }

    @Override
    public String toString() {
        return "Member{" + super.toString() + '}';
    }
}
