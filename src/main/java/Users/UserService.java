package Users;

import org.mindrot.jbcrypt.BCrypt;

public class UserService {

    UserDAO userDAO = new UserDAO();

    public void saveNewUser(User user) {

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(8));
    }
}
