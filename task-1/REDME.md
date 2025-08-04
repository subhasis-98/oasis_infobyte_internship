# 🚆 Online Reservation System (Java Console App)

This is a simple **Java console-based Online Reservation System** where users can book, view, and cancel train tickets. Each ticket is assigned a unique PNR (Passenger Name Record). The system uses a menu-driven approach with basic login authentication.

---

## 📂 Project Structure

OnlineReservationSystem/
│
├── OnlineReservationSystem.java # Main application logic
├── README.md # Project documentation (this file)

---

## 🎯 Features

- 🔐 **Login Authentication**

  - Hardcoded username: `user`
  - Hardcoded password: `pass`

- 🧾 **Book Ticket**  
  Enter passenger details, journey info, and train details to book a ticket. Each ticket receives a unique PNR.

- ❌ **Cancel Ticket**  
  Cancel a ticket using its PNR number.

- 📃 **View All Tickets**  
  Displays all booked tickets with complete details.

- 🚪 **Exit**  
  Exit the system safely.

---

## 🛠 How to Run

### 1. Requirements

- JDK 8 or above installed
- Terminal / Command Line
- A code editor (optional)

### 2. Compile and Run

```bash
javac OnlineReservationSystem.java
java OnlineReservationSystem


Enter username: user
Enter password: pass
Login successful!

1. Book Ticket
2. Cancel Ticket
3. View All Tickets
4. Exit
Enter your choice: 1
Enter name: Alice
From: Delhi
To: Mumbai
Date (DD/MM/YYYY): 15/08/2025
Train No: 12345
Train Name: Rajdhani Express
Ticket booked! PNR: 1000
```

