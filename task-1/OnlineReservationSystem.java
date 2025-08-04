import java.util.*;

class Ticket {
    static int counter = 1000; // Static counter for unique PNR generation
    int pnr;
    String name, from, to, date, trainName;
    int trainNo;

    Ticket(String name, String from, String to, String date, int trainNo, String trainName) {
        this.pnr = counter++; // Assigns and increments PNR
        this.name = name;
        this.from = from;
        this.to = to;
        this.date = date;
        this.trainNo = trainNo;
        this.trainName = trainName;
    }

    public String toString() { // Formats ticket details for display
        return "PNR: " + pnr + " | Name: " + name + " | From: " + from + " | To: " + to +
                " | Date: " + date + " | Train: " + trainName + " (" + trainNo + ")";
    }
}

public class OnlineReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Ticket> tickets = new ArrayList<>(); // Stores all tickets
    static String username = "user"; // Hardcoded login credentials
    static String password = "pass";

    public static void main(String[] args) {
        if (login()) { // Checks login before proceeding
            while (true) { // Menu loop
                System.out.println("\n1. Book Ticket\n2. Cancel Ticket\n3. View All Tickets\n4. Exit");
                System.out.print("Enter your choice: ");
                int ch = sc.nextInt();
                switch (ch) { // Handles menu options
                    case 1:
                        bookTicket();
                        break;
                    case 2:
                        cancelTicket();
                        break;
                    case 3:
                        viewTickets();
                        break;
                    case 4:
                        System.exit(0); // Exits program
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }
    }

    static boolean login() { // Validates user credentials
        System.out.print("Enter username: ");
        String u = sc.next();
        System.out.print("Enter password: ");
        String p = sc.next();
        if (u.equals(username) && p.equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }

    static void bookTicket() { // Creates and stores new ticket
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("From: ");
        String from = sc.next();
        System.out.print("To: ");
        String to = sc.next();
        System.out.print("Date (DD/MM/YYYY): ");
        String date = sc.next();
        System.out.print("Train No: ");
        int trainNo = sc.nextInt();
        sc.nextLine(); // Consumes newline for correct train name input
        System.out.print("Train Name: ");
        String trainName = sc.nextLine();

        Ticket t = new Ticket(name, from, to, date, trainNo, trainName);
        tickets.add(t);
        System.out.println("Ticket booked! PNR: " + t.pnr);
    }

    static void cancelTicket() { // Removes ticket by PNR
        System.out.print("Enter PNR to cancel: ");
        int pnr = sc.nextInt();
        boolean found = false;
        for (Ticket t : tickets) {
            if (t.pnr == pnr) {
                tickets.remove(t); // Removes matching ticket
                System.out.println("Ticket with PNR " + pnr + " cancelled.");
                found = true;
                break; // Exits loop after removal
            }
        }
        if (!found)
            System.out.println("Ticket not found!");
    }

    static void viewTickets() { // Displays all booked tickets
        if (tickets.isEmpty()) {
            System.out.println("No tickets booked.");
            return;
        }
        for (Ticket t : tickets)
            System.out.println(t);
    }
}