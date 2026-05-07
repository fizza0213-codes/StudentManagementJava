# 🎓 Student Management System — Java + BST

> **Author:** Ayesha Arshad  
> **Course:** OOP & Data Structures  
> **Language:** Java 17  
> **IDE:** IntelliJ IDEA  
> Original project: ASP.NET Core MVC (C#) → converted to Java with BST

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
    │   └── Student.java             ← Data model (mirrors C# Student.cs)
    ├── bst/
    │   ├── BSTNode.java             ← BST node
    │   └── StudentBST.java          ← Binary Search Tree (full implementation)
    ├── service/
    │   └── StudentService.java      ← Business logic (mirrors C# controller)
    └── ui/
        └── ConsoleUI.java           ← Console menu (mirrors Razor views)
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
3. The console opens at the bottom — type menu numbers and press Enter

### Step 4 — Build a runnable JAR (optional)
1. Open the **Maven** panel (right side)
2. Expand **Lifecycle** → double-click **package**
3. Find `target/StudentManagement.jar`
4. Run with: `java -jar target/StudentManagement.jar`

---

## 🐙 Deploy to GitHub (Step-by-Step)

### Prerequisites
- Install **Git**: https://git-scm.com/downloads
- Create a **GitHub** account: https://github.com

### Step 1 — Initialize Git in IntelliJ
1. Go to **VCS → Enable Version Control Integration → Git → OK**
2. Or open **Terminal** (bottom of IntelliJ) and run:
   ```bash
   git init
   ```

### Step 2 — Stage and commit your files
In IntelliJ Terminal:
```bash
git add .
git commit -m "Initial commit: Student Management System (Java + BST)"
```

### Step 3 — Create a GitHub repository
1. Go to https://github.com/new
2. Repository name: `StudentManagementSystem-Java`
3. Description: `OOP Student Management with Binary Search Tree — Java`
4. Select **Public**
5. Do NOT check "Add README" (you already have one)
6. Click **Create repository**

### Step 4 — Connect and push
GitHub will show you commands. Run these in IntelliJ Terminal:
```bash
git remote add origin https://github.com/YOUR_USERNAME/StudentManagementSystem-Java.git
git branch -M main
git push -u origin main
```

### Step 5 — Verify
Open your GitHub repo URL — all files should be visible! 🎉

### Making future changes
```bash
git add .
git commit -m "describe what you changed"
git push
```

---

## 📊 C# → Java Mapping

| C# (ASP.NET MVC) | Java Equivalent |
|---|---|
| `Student.cs` (Model) | `model/Student.java` |
| `AppDbContext.cs` (EF Core) | `bst/StudentBST.java` (BST replaces DB) |
| `StudentController.cs` | `service/StudentService.java` |
| Razor Views (`.cshtml`) | `ui/ConsoleUI.java` |
| SQLite database | `students.csv` (file persistence) |
| `IActionResult Index()` | `showAllStudents()` |
| `IActionResult Create()` | `addStudent()` |
| `IActionResult Delete()` | `deleteStudent()` |
| `IActionResult Results()` | `showResults()` |
