package GymMerchandiseManagement;

import Logger.Logger;

public class MerchandiseService {

    private DrinksDAO drinksDAO = new DrinksDAO();
    private FoodsDAO foodsDAO = new FoodsDAO();
    private WorkoutGearDAO workoutGearDAO = new WorkoutGearDAO();

    // Admin operations - add new items
    public void addNewDrink(Drinks drink) {
        System.out.println("Adding new drink: " + drink.getDrinkName());
        drinksDAO.saveNewDrinkToDB(drink);
        Logger.info("New drink added: " + drink.getDrinkName());
        System.out.println("Drink added to inventory!");
    }

    public void addNewFood(Food food) {
        System.out.println("Adding new food: " + food.getFoodName());
        foodsDAO.saveNewFoodToDB(food);
        Logger.info("New food added: " + food.getFoodName());
        System.out.println("Food added to inventory!");
    }

    public void addNewWorkoutGear(WorkoutGear gear) {
        System.out.println("Adding new workout gear: " + gear.getGearName());
        workoutGearDAO.saveNewWorkoutGearToDB(gear);
        Logger.info("New workout gear added: " + gear.getGearName());
        System.out.println("Workout gear added to inventory!");
    }

    // Print stock report for admins
    public void printStockReport() {
        System.out.println("=== STOCK REPORT ===");
        System.out.println("Feature not yet implemented - requires getAllItems methods in DAOs");
        Logger.info("Stock report requested");
    }

    // View products (for members and trainers)
    public void viewAllProducts() {
        System.out.println("=== AVAILABLE PRODUCTS ===");
        System.out.println("Feature not yet implemented - requires getAllItems methods in DAOs");
        Logger.info("Product listing requested");
    }

}
