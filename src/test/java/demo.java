
import java.util.Scanner;

import GymMerchandiseManagement.Merch;
import GymMerchandiseManagement.MerchService;
import MembershipManagement.Membership;
import MembershipManagement.MembershipService;
import Roles.Trainer;
import Users.User;
import Users.UserService;
import WorkoutManagement.WorkoutClass;
import WorkoutManagement.WorkoutClassService;

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

        MerchService merchService = new MerchService();
        WorkoutClassService workoutService = new WorkoutClassService();

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
                        membershipService.viewAllmemberships();
                        break;
                    case "3":
                        membershipService.viewTotalRevenue();
                        break;
                    case "4":
                        System.out.println("Enter merchandise name: ");
                        String name = input.nextLine();

                        System.out.println("Enter description: ");
                        String desc = input.nextLine();

                        System.out.println("Enter merchandise type (e.g., drink, food, gear): ");
                        String type = input.nextLine();

                        System.out.println("Enter cost: ");
                        double cost = Double.parseDouble(input.nextLine());

                        System.out.println("Enter quantity: ");
                        int quantity = Integer.parseInt(input.nextLine());

                        Merch merch = new Merch(name, desc, type, cost, quantity);

                        merchService.addNewMerch(merch);

                        break;
                    case "5":
                        System.out.println("Update merch cost selected.");
                        break;
                    case "6":
                        merchService.printStockReport();
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

                        System.out.println("Enter workout type (Yoga, HIIT, Spin, etc.): ");
                        String wcType = input.nextLine();

                        System.out.println("Enter workout description: ");
                        String wcDesc = input.nextLine();

                        WorkoutClass newClass = new WorkoutClass(wcType, wcDesc, String.valueOf(loggedInUser.getUserId()));

                        workoutService.saveNewWorkoutClass(newClass, (Trainer) loggedInUser);
                        break;

                    case "2":
                        System.out.println("Enter the ID of the class you want to update: ");
                        String updateId = input.nextLine();

                        System.out.println("Enter new class type: ");
                        String newType = input.nextLine();

                        System.out.println("Enter new class description: ");
                        String newDesc = input.nextLine();

                        WorkoutClass updatedClass = new WorkoutClass(updateId, newType, newDesc, String.valueOf(loggedInUser.getUserId()));

                        break;
                    case "3":
                        System.out.println("Enter the ID of the class to delete: ");
                        String deleteId = input.nextLine();

                        workoutService.deleteWorkoutClass(deleteId);
                        break;
                    case "4":
                        System.out.println("View assigned classes.");
                        break;
                    case "5":
                        purchaseMembership(loggedInUser);
                        break;
                    case "6":
                        merchService.viewAllProducts();
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
                        workoutService.viewAllWorkoutClasses();
                        break;
                    case "2":
                        System.out.println("Viewing joined classes...");
                        break;
                    case "3":
                        purchaseMembership(loggedInUser);
                        break;
                    case "4":
                        merchService.viewAllProducts();
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

    private static void purchaseMembership(User user) {

        Scanner in = new Scanner(System.in);
        MembershipService membershipService = new MembershipService();

        System.out.println("\n=== Purchase Membership ===");

        System.out.println("Choose membership type:");
        System.out.println("1. Monthly");
        System.out.println("2. Quarterly");
        System.out.println("3. Yearly");
        System.out.print("Enter choice: ");

        String choice = in.nextLine();
        String type = "";
        double cost = 0.0;
        String desc = "";

        switch (choice) {
            case "1":
                type = "Monthly";
                cost = 39.99;
                desc = "30-day gym access";
                break;
            case "2":
                type = "Quarterly";
                cost = 99.99;
                desc = "90-day gym access";
                break;
            case "3":
                type = "Yearly";
                cost = 299.99;
                desc = "Full-year gym access";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        Membership membership = new Membership(type, desc, cost, user.getUserId());

        membershipService.saveNewMembership(membership, user);

        System.out.println("Membership purchase successful!");
    }

}
