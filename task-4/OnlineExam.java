import java.util.*;

public class OnlineExam {
    Scanner sc = new Scanner(System.in);
    String username = "student";
    String password = "1234";
    String name = "John Doe";
    String email = "john@example.com";
    int score = 0;

    // Start the app
    void start() {
        if (login()) {
            int choice;
            do {
                System.out.println("\n--- Online Examination System ---");
                System.out.println("1. Update Profile");
                System.out.println("2. Update Password");
                System.out.println("3. Start Exam");
                System.out.println("4. Logout");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> updateProfile();
                    case 2 -> updatePassword();
                    case 3 -> startExam();
                    case 4 -> System.out.println("Logged out successfully!");
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Login failed! Exiting...");
        }
    }

    // Login method
    boolean login() {
        System.out.print("Enter username: ");
        String u = sc.next();
        System.out.print("Enter password: ");
        String p = sc.next();
        return u.equals(username) && p.equals(password);
    }

    // Update profile info
    void updateProfile() {
        sc.nextLine(); // consume leftover newline
        System.out.print("Enter new name: ");
        name = sc.nextLine();
        System.out.print("Enter new email: ");
        email = sc.nextLine();
        System.out.println("Profile updated successfully!");
    }

    // Update password
    void updatePassword() {
        System.out.print("Enter current password: ");
        String oldPass = sc.next();
        if (oldPass.equals(password)) {
            System.out.print("Enter new password: ");
            password = sc.next();
            System.out.println("Password updated successfully!");
        } else {
            System.out.println("Wrong password!");
        }
    }

    // Start the exam with a simple timer
    void startExam() {
        score = 0;
        System.out.println("Exam started. You have 30 seconds to answer 3 questions!");

        long startTime = System.currentTimeMillis();
        long allowedTime = 30 * 1000; // 30 seconds

        // Question 1
        if (!isTimeUp(startTime, allowedTime)) {
            System.out.println("\nQ1. What is the capital of India?");
            System.out.println("a) Mumbai\nb) Delhi\nc) Kolkata\nd) Chennai");
            System.out.print("Answer: ");
            String ans = sc.next();
            if (ans.equalsIgnoreCase("b"))
                score++;
        }

        // Question 2
        if (!isTimeUp(startTime, allowedTime)) {
            System.out.println("\nQ2. 5 + 3 = ?");
            System.out.println("a) 6\nb) 7\nc) 8\nd) 9");
            System.out.print("Answer: ");
            String ans = sc.next();
            if (ans.equalsIgnoreCase("c"))
                score++;
        }

        // Question 3
        if (!isTimeUp(startTime, allowedTime)) {
            System.out.println("\nQ3. Which language is used for Android?");
            System.out.println("a) Python\nb) Java\nc) C++\nd) PHP");
            System.out.print("Answer: ");
            String ans = sc.next();
            if (ans.equalsIgnoreCase("b"))
                score++;
        }

        System.out.println("\nTime's up or exam finished!");
        System.out.println("Your score: " + score + "/3");
    }

    // Check if time is up
    boolean isTimeUp(long startTime, long allowedTime) {
        if (System.currentTimeMillis() - startTime > allowedTime) {
            System.out.println("\n⏰ Time's up!");
            return true;
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        new OnlineExam().start();
    }
}
