# Library Management System

Java-based web application using Spring Boot and MySQL.
# Library Management System

A complete Java-based web application to manage a digital library using **Spring Boot**, **MySQL**, and a basic **HTML/JS frontend**.

---

## Features

### 🔐 Admin
- Add, update, delete books
- Add, update, delete members

### 👤 User
- Browse books
- Issue and return books
- Send email queries
- View issued book reports

### 🛠 Common
- Fine calculation for late returns
- Role-based access (admin/user)
- Email support for user queries

---

## Tech Stack

- **Backend:** Java 17+, Spring Boot, Spring Data JPA, Spring Security, JavaMail
- **Frontend:** HTML, Bootstrap 5, JavaScript, Axios
- **Database:** MySQL
- **Build Tool:** Maven

---

## Setup Instructions

### 1. Prerequisites
- Java 17+
- Maven
- MySQL server
- SMTP account (e.g., Gmail App Password)

### 2. MySQL Setup
```sql
CREATE DATABASE library_db;
USE library_db;

CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    isbn VARCHAR(13),
    available BOOLEAN
);

CREATE TABLE member (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    role VARCHAR(50)
);

CREATE TABLE transaction (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT,
    member_id BIGINT,
    issue_date DATE,
    due_date DATE,
    return_date DATE,
    fine DOUBLE,
    FOREIGN KEY (book_id) REFERENCES book(id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);
