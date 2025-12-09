
import java.util.Scanner;

import Users.User;
import Users.UserService;

public class demo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        UserService userService = new UserService();
        boolean running = true;

        while (running) {
            System.out.println("========== Main Menu ==========");
            System.out.println("1. Register new user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Registering new user...");
                    registerUser(userService, input);
                    break;
                case "2":
                    System.out.println("Logging in...");
                    // Login logic here
                    break;
                case "3":
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Register user
    private static void registerUser(UserService userService, Scanner input) {

        System.out.println("Enter username: ");
        String userName = input.nextLine();

        if (userService.usernameExists(userName)) {
            System.out.println("Username already exists. Please try a different one.");
            return;
        }

        System.out.println("Enter password: ");
        String password = input.nextLine();
        System.out.println("Enter email: ");
        String email = input.nextLine();
        System.out.println("Enter phone number: ");
        String phone = input.nextLine();
        System.out.println("Enter address: ");
        String address = input.nextLine();
        System.out.println("Enter role (admin/trainer/member): ");
        String role = input.nextLine();

        User user = new User(userName, password, email, phone, address, role);

        userService.saveNewUser(user);
    }

    // Login user
    public static void loginUser(UserService userService, Scanner input) {

        System.out.println("Enter username: ");
        String userName = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();

        User loggedInUser = userService.userLogIn(userName, password);

        if (loggedInUser != null) {
            System.out.println("Welcome " + loggedInUser.getUserName());

            if (userService.isAdmin(loggedInUser)) {
                System.out.println("========== Admin menu ==========");
                System.out.println("1. Delete user");
                System.out.println("2. View all gym memberships");
                System.out.println("3. View annual revenue");
                System.out.println("4. Add new merch item");
                System.out.println("5. Update merch item cost");
                System.out.println("6. Print merch stock report");
                System.out.println("7. Print toatl merch stock value");

            } else if (userService.isTrainer(loggedInUser)) {
                System.out.println("========== Trainer menu ==========");
                System.out.println("1. Create workout class");
                System.out.println("2. Update workout class");
                System.out.println("3. Delete workout class");
                System.out.println("4. View all assigned classes");
                System.out.println("5. Purchase gym membership");
                System.out.println("6. View all merch");

            } else if (userService.isMember(loggedInUser)) {
                System.out.println("========== Member menu ==========");
                System.out.println("1. Browse workout classes");
                System.out.println("2. View joined classes");
                System.out.println("3. Purchase gym membership");
                System.out.println("4. View all merch");

            }
        }
    }
}
