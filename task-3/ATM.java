import java.util.*;

public class ATM {
    private double balance = 0; // Initial account balance
    private String userId = "user123"; // Default user ID
    private String userPin = "1234"; // Default user PIN
    private List<String> history = new ArrayList<>(); // To store transaction history
    Scanner sc = new Scanner(System.in); // Scanner for user input

    // Starts the ATM application
    void start() {
        if (login()) {
            int choice;

            // Display menu until the user chooses to exit
            do {
                System.out.println("\n--- ATM Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Transfer");
                System.out.println("4. Check Balance");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                // Switch case to handle user actions
                switch (choice) {
                    case 1:
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        transfer();
                        break;
                    case 4:
                        checkBalance();
                        break;
                    case 5:
                        showHistory();
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 6);
        } else {
            System.out.println("Login failed. Exiting program.");
        }
    }

    // Login function to authenticate the user
    boolean login() {
        System.out.print("Enter User ID: ");
        String uid = sc.next();
        System.out.print("Enter PIN: ");
        String pin = sc.next();

        if (uid.equals(userId) && pin.equals(userPin)) {
            System.out.println("Login successful.");
            return true;
        } else {
            return false;
        }
    }

    // Deposit method
    void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amt = sc.nextDouble();
        if (amt > 0) {
            balance += amt;
            history.add("Deposited: " + amt);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Withdraw method
    void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amt = sc.nextDouble();
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            history.add("Withdrawn: " + amt);
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Transfer method
    void transfer() {
        System.out.print("Enter recipient account ID: ");
        String acc = sc.next();
        System.out.print("Enter amount to transfer: ");
        double amt = sc.nextDouble();
        if (amt > 0 && amt <= balance) {
            balance -= amt;
            history.add("Transferred: " + amt + " to account " + acc);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Check balance method
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Show transaction history
    void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("--- Transaction History ---");
            for (String h : history) {
                System.out.println(h);
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
