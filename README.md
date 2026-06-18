# Student Record Management System (Java)

Yo 👋 this is my Java project for managing student records.  
It’s a console app where you can add, search, update, delete, and display students.  
I also made it save data in different formats (text, binary, and serialized objects) so you can see how file handling works in Java.

---

## 🚀 Features
- [Add Student](ca://s?q=Add_student_in_Java_project) → enter ID, name, department, GPA  
- [Search Student](ca://s?q=Search_student_in_Java_project) → find by ID  
- [Update Student](ca://s?q=Update_student_in_Java_project) → change name, department, GPA  
- [Delete Student](ca://s?q=Delete_student_in_Java_project) → remove by ID  
- [Display All](ca://s?q=Display_all_students_in_Java_project) → shows all students (preloaded + new ones)  
- [Reports](ca://s?q=Generate_student_report_in_Java_project) → total count, highest GPA, lowest GPA, average GPA  
- [Backup](ca://s?q=Backup_student_records_in_Java_project) → creates a backup file using buffered streams  
- [File Properties](ca://s?q=Show_file_properties_in_Java_project) → shows name, path, size, last modified  

---

## 📂 Project Structure
Student.java        
StudentManager.java 
Main.java          
/data
students.txt     // sample records (committed to repo)
students.dat     // generated at runtime
students.ser     // generated at runtime
backup.ser       // created when you run backup
README.md           // this file


---

## 📝 How It Works
- On first run, the program **preloads 5 sample students** into `/data/students.txt`.  
- Every time you add or update, it saves to:
  - `students.txt` → human‑readable text file  
  - `students.dat` → binary file  
  - `students.ser` → serialized objects  
- Press **5** in the menu to see all students.  
- Press **6** to generate a report.  

---

## 🎮 Sample Output
--- Student Record Management ---

1.Add Student

2.Search Student

3.Update Student

4.Delete Student

5.Display All Students

6.Generate Report

7.Backup

8.File Properties

9.Exit

Choose option: 5

S001 | John Doe | Computer Science | GPA: 3.8
S002 | Jane Smith | Electrical Engineering | GPA: 3.5
S003 | Michael Brown | Mechanical Engineering | GPA: 2.9
S004 |Sarah Johnson | Business Administration | GPA: 3.2
S005 | Emily Davis | Information Technology | GPA: 3.9


---

## ⚡ Notes
- Only `students.txt` is committed in the repo as sample data.  
- Other files (`.dat`, `.ser`, `backup.ser`) are generated when you run the program.  
- You can change the preloaded names in `preloadSampleRecords()` inside `StudentManager.java`.  

---

Made this project to practice Java file handling, OOP, and exception handling.  
It’s simple, but it covers a lot of core concepts. 🚀 
Thank You!!!


