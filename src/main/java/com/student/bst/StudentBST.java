package com.student.bst;

import com.student.model.Student;
import java.util.*;

public class StudentBST {
    private BSTNode root;

    public void insert(Student s) { root = insert(root, s); }
    private BSTNode insert(BSTNode n, Student s) {
        if (n == null) return new BSTNode(s);
        if (s.getId() < n.student.getId()) n.left = insert(n.left, s);
        else n.right = insert(n.right, s);
        return balance(n);
    }

    public Student search(int id) {
        BSTNode curr = root;
        while (curr != null) {
            if (id == curr.student.getId()) return curr.student;
            curr = (id < curr.student.getId()) ? curr.left : curr.right;
        }
        return null;
    }

    public void delete(int id) { root = delete(root, id); }
    private BSTNode delete(BSTNode root, int id) {
        if (root == null) return null;
        if (id < root.student.getId()) root.left = delete(root.left, id);
        else if (id > root.student.getId()) root.right = delete(root.right, id);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.student = findMin(root.right).student;
            root.right = delete(root.right, root.student.getId());
        }
        return balance(root);
    }

    private BSTNode findMin(BSTNode n) { while (n.left != null) n = n.left; return n; }

    // Standard AVL Balancing to handle 1 Million records efficiently
    private int height(BSTNode n) { return n == null ? 0 : n.height; }
    private BSTNode balance(BSTNode p) {
        p.height = 1 + Math.max(height(p.left), height(p.right));
        int bf = height(p.left) - height(p.right);
        if (bf > 1) {
            if (height(p.left.left) < height(p.left.right)) p.left = rotateLeft(p.left);
            return rotateRight(p);
        }
        if (bf < -1) {
            if (height(p.right.right) < height(p.right.left)) p.right = rotateRight(p.right);
            return rotateLeft(p);
        }
        return p;
    }
    private BSTNode rotateRight(BSTNode y) {
        BSTNode x = y.left; y.left = x.right; x.right = y;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    private BSTNode rotateLeft(BSTNode x) {
        BSTNode y = x.right; x.right = y.left; y.left = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }
    private void inOrder(BSTNode n, List<Student> l) {
        if (n != null) { inOrder(n.left, l); l.add(n.student); inOrder(n.right, l); }
    }
}