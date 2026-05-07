package com.student.service;

import com.student.bst.StudentBST;
import com.student.model.Student;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class StudentService {
    private final StudentBST bst = new StudentBST();
    private final String DB_FILE = "students_db.txt";

    public StudentService() {
        loadDatabase(); // Load data when app starts
    }

    public String addStudent(String name, String marksStr, String email) {
        // 1. Validate inputs
        String validationError = Student.validate(name, marksStr, email);
        if (validationError != null) return validationError;

        // 2. Create student with unique ID
        int id = (int)(Math.random() * 900000) + 100000;
        Student s = new Student(id, name.trim(), Integer.parseInt(marksStr.trim()), email.trim(), LocalDateTime.now());

        // 3. Insert into BST and Save to File
        bst.insert(s);
        saveDatabase();
        return null;
    }

    public void deleteStudent(int id) {
        bst.delete(id);
        saveDatabase();
    }

    public Student searchStudent(int id) {
        return bst.search(id);
    }

    public List<Student> getHistory() {
        return bst.getAll();
    }

    // --- Persistence Logic ---
    private void saveDatabase() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DB_FILE))) {
            for (Student s : bst.getAll()) {
                writer.println(s.toCSV());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void loadDatabase() {
        File file = new File(DB_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    Student s = new Student(
                            Integer.parseInt(parts[0]), parts[1],
                            Integer.parseInt(parts[2]), parts[3],
                            LocalDateTime.parse(parts[4])
                    );
                    bst.insert(s);
                }
            }
        } catch (Exception e) { System.out.println("Starting fresh database."); }
    }
}