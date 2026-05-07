# 🎓 Student Management System — Java + BST

> **Author:** Fizza Afzal 
> **Course:** OOP & Data Structures  
> **Language:** Java 17  
> **IDE:** IntelliJ IDEA  
>  project:Java with BST

---

## 📐 Project Structure

```
StudentManagementJava/
├── pom.xml                          ← Maven build file
├── .gitignore
├── README.md
└── src/main/java/com/student/
    ├── Main.java                    ← Entry point
    ├── model/
    │   └── Student.java             ← Data model
    ├── bst/
    │   ├── BSTNode.java             ← BST node
    │   └── StudentBST.java          ← Binary Search Tree (full implementation)
    ├── service/
    │   └── StudentService.java      ← Business logic
    └── ui/
        └── GUI.java         
```

---

## 🌳 Data Structure: Binary Search Tree

| Feature | Detail |
|---|---|
| **Ordering key** | `marks` (int) |
| **Insert** | O(h) |
| **Delete** | O(n) — must scan for id first |
| **Search by ID/Name/Email** | O(n) |
| **Range search** | O(log n + k) — BST-optimised |
| **Min/Max (top/bottom student)** | O(h) |
| **Sorted list** | O(n) in-order traversal |
| **Duplicates** | Allowed (go to right subtree) |

`h` = tree height. Balanced case: O(log n).

---

## ✅ Features

- Add / Delete / Update students
- Search by ID, Name (partial), Email (partial)
- Range search by marks range
- Sorted view (ascending / descending by marks)
- Results & Analytics: total, pass/fail count, average, top student, grade distribution
- CSV file persistence (data saved between runs)

---

## 🖥️ How to Open in IntelliJ IDEA

### Step 1 — Open the project
1. Open **IntelliJ IDEA**
2. Click **File → Open**
3. Select the `StudentManagementJava` folder
4. Click **OK** → IntelliJ detects `pom.xml` and asks *"Import as Maven project?"* → click **Yes / Trust Project**

### Step 2 — Set Java SDK
1. Go to **File → Project Structure → Project**
2. Under **SDK**, select **Java 17** (or 11+)
3. Click **OK**

### Step 3 — Run the program
1. Open `src/main/java/com/student/Main.java`
2. Click the **▶ green play button** next to `main()`


   <img width="1082" height="692" alt="image" src="https://github.com/user-attachments/assets/c926e04e-e336-4337-924c-f23cb36190b1" />


