# Preface

We didn't realize that there was a template repo to start from, so we started from scratch. Forgive any minor bugs, but we did quite a bit of testing.

# Gym Management System - User Documentation

## Overview

The Gym Management System is a Java-based application designed to manage gym operations including user registration, memberships, workout classes, and merchandise inventory. The system supports role-based access with three user types: Admin, Trainer, and Member.

## System Requirements

- Java 17 or higher
- PostgreSQL database
- Maven 3.6+ for building
- BCrypt library for password hashing

## Database Setup

The system requires a PostgreSQL database with the following tables:

### Users Table

```sql
CREATE TABLE users (
    userId SERIAL PRIMARY KEY,
    userName VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    role VARCHAR(20) NOT NULL CHECK (role IN ('Admin', 'Trainer', 'Member'))
);
```

### Membership Table

```sql
CREATE TABLE membership (
    msId VARCHAR(50) PRIMARY KEY,
    msType VARCHAR(50) NOT NULL,
    msDesc TEXT,
    msCost DECIMAL(10,2) NOT NULL,
    userId INTEGER REFERENCES users(userId)
);
```

### WorkoutClass Table

```sql
CREATE TABLE workoutclass (
    wcId VARCHAR(50) PRIMARY KEY,
    wcType VARCHAR(50) NOT NULL,
    wcDesc TEXT,
    trainerId VARCHAR(50) NOT NULL
);
```

### Merchandise Tables

```sql
CREATE TABLE merch (
    merchId SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    desc TEXT,
    type TEXT,
    cost DECIMAL(10,2) NOT NULL,
    quantity INTEGER NOT NULL
);
```

## Building and Running the Application

### Prerequisites

1. Install Java 17+
2. Install Maven
3. Set up PostgreSQL database
4. Update database connection details in `DatabaseConnection.java`

### Building

```bash
mvn clean compile
mvn package
```

### Running

```bash
java -cp target/gym-app-1.0.0-SNAPSHOT.jar Main
```

## User Roles and Permissions

### Admin

**Capabilities:**

- View and manage all users
- Track membership revenue and statistics
- Add new merchandise (drinks, food, workout gear)
- Update merchandise costs and pricing
- Generate stock reports and inventory valuation
- Delete users from the system

**Key Operations:**

- User management (view all, delete users)
- Revenue tracking and reporting
- Inventory management and reporting
- Merchandise cost management
- System administration

### Trainer

**Capabilities:**

- Purchase gym memberships
- Create, update, and delete workout classes
- View their assigned workout classes
- View available merchandise
- Manage their own workout class schedule

**Key Operations:**

- Workout class CRUD operations
- View assigned classes and schedules
- Membership purchases
- Product browsing
- View their assigned workout classes
- View available merchandise
- Manage their own workout class schedule

**Key Operations:**

- Workout class CRUD operations
- View assigned classes and schedules
- Membership purchases
- Product browsing

### Member

**Capabilities:**

- Purchase gym memberships
- View available workout classes
- Browse gym merchandise
- View their total membership expenses

**Key Operations:**

- Membership purchases
- Personal expense tracking
- Class browsing
- Product viewing

## Core Features

### User Registration and Authentication

- **Registration**: Users register with username, password, email, phone, address, and role
- **Password Security**: Passwords are hashed using BCrypt before storage
- **Login**: Username/password authentication with role-based access
- **Session Management**: Users can log in and out of the system

### Membership Management

- **Purchase Memberships**: Members and trainers can buy gym memberships
- **Revenue Tracking**: Admins can view total revenue from membership sales
- **Statistics**: Admins can see membership type breakdowns and averages
- **Membership Types**: Support for different membership tiers and pricing

### Workout Class Management

- **Class Creation**: Trainers can add new workout classes
- **Class Updates**: Trainers can modify existing class details
- **Class Deletion**: Trainers can remove classes from the system
- **Class Viewing**: Members can browse available workout classes
- **Trainer Assignment**: Classes are linked to specific trainers

### Merchandise Management

- **Product Categories**: Three types - Drinks, Food, and Workout Gear
- **Admin Operations**: Add new products, set prices, manage inventory
- **Stock Reports**: Comprehensive inventory reports showing quantities and values
- **Product Browsing**: Members and trainers can view available products
- **Inventory Tracking**: Real-time quantity tracking

## API Reference

### UserService Methods

- `saveNewUser(User user)` - Register new user with BCrypt password hashing
- `userLogIn(String userName, String password)` - Authenticate user and return User object
- `getUserByUsername(String username)` - Retrieve user by username
- `verifyPassword(String plainPassword, String hashedPassword)` - Verify password matches its hashed version
- `getUserById(int id)` - Find a user by their ID
- `getAllUsers()` - Get all users (Admin only)
- `deleteUserById(int id)` - Remove user (Admin only)
- `isAdmin(User user)` - Check if user has admin role
- `isTrainer(User user)` - Check if user has trainer role
- `isMember(User user)` - Check if user has member role
- `usernameExists(String username)` - Check if username is already registered
- `logout(User user)` - Log out the specified user

### MembershipService Methods

- `saveNewMembership(Membership membership, User user)` - Purchase membership for members/trainers
- `viewTotalRevenue()` - Calculate and display total revenue from all memberships (Admin)
- `viewAllmemberships()` - Show comprehensive membership statistics (Admin)
- `viewMemberExpenses(User user)` - Display total membership expenses for a specific member

### WorkoutClassService Methods

- `saveNewWorkoutClass(WorkoutClass workoutClass, Trainer trainer)` - Create new workout class (Trainer)
- `updateWorkoutClass(WorkoutClass workoutClass)` - Modify existing class details (Trainer)
- `deleteWorkoutClass(int wcId)` - Remove workout class from system (Trainer)
- `viewAllWorkoutClasses()` - List all available workout classes (Member/Trainer)
- `viewAllAssignedWorkoutClasses(Trainer trainer)` - Show classes assigned to specific trainer
- `viewAllAssignedMemberWorkoutClasses()` - Display workout classes available to members

### MerchandiseService Methods

- `addNewMerch(Merch merch)` - Add new merchandise to inventory (Admin)
- `printStockReport()` - Generate comprehensive inventory report (Admin)
- `viewAllProducts()` - Browse all available merchandise (Member/Trainer)
- `viewTotalMerchValue()` - Calculate and display total monetary value of all merchandise
- `updateMerchCost(int merchId, double newCost)` - Update the cost of existing merchandise item (Admin)

## Configuration

Update these files for your environment:

### DatabaseConnection.java

```java
private static final String URL = "jdbc:postgresql://localhost:5432/your_database";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

### Maven Dependencies (pom.xml)

- BCrypt: `org.mindrot:jbcrypt:0.4`
- PostgreSQL: `org.postgresql:postgresql:42.7.3`
