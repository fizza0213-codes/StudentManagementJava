package com.student.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student implements Serializable {
    private final int id;
    private String name, email;
    private int marks;
    private final LocalDateTime createdAt;

    public Student(int id, String name, int marks, String email, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.email = email;
        this.createdAt = createdAt;
    }

    // --- Strict Validation ---
    public static String validate(String name, String marksStr, String email) {
        if (name == null || name.trim().length() < 2)
            return "Error: Name must be at least 2 characters.";

        try {
            int m = Integer.parseInt(marksStr);
            if (m < 0 || m > 100) return "Error: Marks must be between 0 and 100.";
        } catch (NumberFormatException e) {
            return "Error: Marks must be a valid number.";
        }

        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            return "Error: Invalid email format (e.g., user@example.com).";

        return null; // Null means validation passed
    }

    public String toCSV() {
        return id + "|" + name + "|" + marks + "|" + email + "|" + createdAt;
    }

    public String getGrade() {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        return "F";
    }

    public String getStatus() { return marks >= 50 ? "Pass" : "Fail"; }
    public int getId() { return id; }
    public String getName() { return name; }
    public int getMarks() { return marks; }
    public String getEmail() { return email; }
    public String getFormattedDate() {
        return createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}