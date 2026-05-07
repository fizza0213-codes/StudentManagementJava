package com.student.bst;
import com.student.model.Student;

public class BSTNode {
    public Student student;
    public BSTNode left, right;
    public int height = 1;
    public BSTNode(Student s) { this.student = s; }
}