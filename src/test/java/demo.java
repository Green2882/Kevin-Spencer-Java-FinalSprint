
import java.util.Scanner;

import MembershipManagement.MembershipService;
import Users.User;
import Users.UserService;

public class demo {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        UserService userService = new UserService();
        MembershipService membershipService = new MembershipService();
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
                    loginUser(userService, membershipService, input);
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
    public static void loginUser(UserService userService, MembershipService membershipService, Scanner input) {

        System.out.print("Enter username: ");
        String userName = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        User loggedInUser = userService.userLogIn(userName, password);

        if (loggedInUser == null) {
            return;
        }

        System.out.println("Welcome " + loggedInUser.getUserName());

        // ADMIN MENU
        if (userService.isAdmin(loggedInUser)) {
            boolean adminRunning = true;

            while (adminRunning) {
                System.out.println("========== Admin Menu ==========");
                System.out.println("1. Delete user");
                System.out.println("2. View all gym memberships");
                System.out.println("3. View annual revenue");
                System.out.println("4. Add new merch item");
                System.out.println("5. Update merch item cost");
                System.out.println("6. Print merch stock report");
                System.out.println("7. Print total merch stock value");
                System.out.println("0. Logout");
                System.out.print("Enter choice: ");
                String choice = input.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("Enter user ID to delete: ");
                        int deletedId = Integer.parseInt(input.nextLine());

                        boolean deleted = userService.deleteUserById(deletedId);

                        if (deleted) {
                            System.out.println("User successfully deleted");
                        } else {
                            System.out.println("User not found");
                        }
                        break;

                    case "2":
                        System.out.println("View memberships selected.");
                        break;
                    case "3":
                        membershipService.viewTotalRevenue();
                        break;
                    case "4":
                        System.out.println("Add merch selected.");
                        break;
                    case "5":
                        System.out.println("Update merch cost selected.");
                        break;
                    case "6":
                        System.out.println("Print stock report selected.");
                        break;
                    case "7":
                        System.out.println("Print total stock value selected.");
                        break;
                    case "0":
                        userService.logout(loggedInUser);
                        adminRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } // TRAINER MENU
        else if (userService.isTrainer(loggedInUser)) {
            boolean trainerRunning = true;

            while (trainerRunning) {
                System.out.println("========== Trainer Menu ==========");
                System.out.println("1. Create workout class");
                System.out.println("2. Update workout class");
                System.out.println("3. Delete workout class");
                System.out.println("4. View all assigned classes");
                System.out.println("5. Purchase gym membership");
                System.out.println("6. View all merch");
                System.out.println("0. Logout");
                System.out.print("Enter choice: ");
                String choice = input.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("Create class selected.");
                        break;
                    case "2":
                        System.out.println("Update class selected.");
                        break;
                    case "3":
                        System.out.println("Delete class selected.");
                        break;
                    case "4":
                        System.out.println("View assigned classes.");
                        break;
                    case "5":
                        System.out.println("Membership purchase selected.");
                        break;
                    case "6":
                        System.out.println("View merch selected.");
                        break;
                    case "0":
                        userService.logout(loggedInUser);
                        trainerRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } // MEMBER MENU
        else if (userService.isMember(loggedInUser)) {
            boolean memberRunning = true;

            while (memberRunning) {
                System.out.println("========== Member Menu ==========");
                System.out.println("1. Browse workout classes");
                System.out.println("2. View joined classes");
                System.out.println("3. Purchase gym membership");
                System.out.println("4. View all merch");
                System.out.println("0. Logout");
                System.out.print("Enter choice: ");
                String choice = input.nextLine();

                switch (choice) {
                    case "1":
                        System.out.println("Browsing classes...");
                        break;
                    case "2":
                        System.out.println("Viewing joined classes...");
                        break;
                    case "3":
                        System.out.println("Purchasing membership...");
                        break;
                    case "4":
                        System.out.println("Viewing merch...");
                        break;
                    case "0":
                        userService.logout(loggedInUser);
                        memberRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

}
