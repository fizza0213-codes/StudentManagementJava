package com.student.ui;

import com.student.model.Student;
import com.student.service.StudentService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainGUI extends JFrame {
    private StudentService service = new StudentService();
    private DefaultTableModel model;
    private JTextField searchField;

    public MainGUI() {
        setupUI();
        refreshTable();
    }

    private void setupUI() {
        setTitle("Enterprise Student Management - History & Database");
        setSize(1100, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header (Professional Blue)
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(0, 80, 157));
        header.setPreferredSize(new Dimension(100, 70));

        JLabel title = new JLabel("  STUDENT RECORD SYSTEM");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        header.add(title, BorderLayout.WEST);

        // Control Panel
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 20));
        controls.setOpaque(false);
        searchField = new JTextField(12);
        JButton btnSearch = new JButton("Search ID");
        JButton btnDelete = new JButton("Delete ID");
        JButton btnAdd = new JButton("+ New Student");

        controls.add(new JLabel("ID:")).setForeground(Color.WHITE);
        controls.add(searchField);
        controls.add(btnSearch);
        controls.add(btnDelete);
        controls.add(btnAdd);
        header.add(controls, BorderLayout.EAST);

        add(header, BorderLayout.NORTH);

        // Table History
        String[] columns = {"ID", "Name", "Marks", "Grade", "Status", "Email", "Date Created"};
        model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setRowHeight(35);
        table.setBackground(new Color(245, 245, 245));

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Action Listeners
        btnAdd.addActionListener(e -> showInputForm());

        btnSearch.addActionListener(e -> {
            try {
                Student s = service.searchStudent(Integer.parseInt(searchField.getText()));
                if (s != null) {
                    model.setRowCount(0);
                    addRow(s);
                } else JOptionPane.showMessageDialog(this, "No record found for this ID.");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Enter a numeric ID."); }
        });

        btnDelete.addActionListener(e -> {
            try {
                service.deleteStudent(Integer.parseInt(searchField.getText()));
                refreshTable();
                JOptionPane.showMessageDialog(this, "Record successfully deleted from database.");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "ID not found."); }
        });
    }

    private void showInputForm() {
        JTextField name = new JTextField(), marks = new JTextField(), email = new JTextField();
        Object[] message = {"Student Name:", name, "Marks (0-100):", marks, "Email:", email};

        int option = JOptionPane.showConfirmDialog(this, message, "Add New Record", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String result = service.addStudent(name.getText(), marks.getText(), email.getText());
            if (result != null) {
                JOptionPane.showMessageDialog(this, result, "Validation Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                refreshTable();
            }
        }
    }

    private void refreshTable() {
        model.setRowCount(0);
        for (Student s : service.getHistory()) { addRow(s); }
    }

    private void addRow(Student s) {
        model.addRow(new Object[]{s.getId(), s.getName(), s.getMarks(), s.getGrade(), s.getStatus(), s.getEmail(), s.getFormattedDate()});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}