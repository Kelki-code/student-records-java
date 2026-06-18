import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private File textFile = new File("data/students.txt");
    private File binaryFile = new File("data/students.dat");
    private File objectFile = new File("data/students.ser");

    public StudentManager() {
        File dir = new File("data");
        if (!dir.exists()) dir.mkdirs();

        loadFromObject();
        if (students.isEmpty()) {
            preloadSampleRecords();
        }
    }


    private void preloadSampleRecords() {
        students.add(new Student("S001", "John Doe", "Computer Science", 3.8));
        students.add(new Student("S002", "Jane Smith", "Electrical Engineering", 3.5));
        students.add(new Student("S003", "Michael Brown", "Mechanical Engineering", 2.9));
        students.add(new Student("S004", "Sarah Johnson", "Business Administration", 3.2));
        students.add(new Student("S005", "Emily Davis", "Information Technology", 3.9));

        saveToText();
        saveToBinary();
        saveToObject();
    }

    @SuppressWarnings("unchecked")
    private void loadFromObject() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objectFile))) {
            students = (List<Student>) ois.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToText();
        saveToBinary();
        saveToObject();
    }

    public Student searchById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equals(id)) return s;
        }
        return null;
    }

    public boolean updateStudent(String id, String name, String dept, double gpa) {
        Student s = searchById(id);
        if (s != null) {
            s.setName(name);
            s.setDepartment(dept);
            s.setGpa(gpa);
            saveToText();
            saveToBinary();
            saveToObject();
            return true;
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        Student s = searchById(id);
        if (s != null) {
            students.remove(s);
            saveToText();
            saveToBinary();
            saveToObject();
            return true;
        }
        return false;
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void generateReport() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        double max = students.stream().mapToDouble(Student::getGpa).max().orElse(0);
        double min = students.stream().mapToDouble(Student::getGpa).min().orElse(0);
        double avg = students.stream().mapToDouble(Student::getGpa).average().orElse(0);

        System.out.println("Total Students: " + students.size());
        System.out.println("Highest GPA: " + max);
        System.out.println("Lowest GPA: " + min);
        System.out.println("Average GPA: " + avg);
    }

    private void saveToText() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(textFile))) {
            for (Student s : students) {
                pw.println(s.getStudentId() + "," + s.getName() + "," + s.getDepartment() + "," + s.getGpa());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void saveToBinary() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(binaryFile))) {
            for (Student s : students) {
                dos.writeUTF(s.getStudentId());
                dos.writeUTF(s.getName());
                dos.writeUTF(s.getDepartment());
                dos.writeDouble(s.getGpa());
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void saveToObject() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objectFile))) {
            oos.writeObject(students);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void backup() {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(objectFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("data/backup.ser"))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Backup created successfully.");
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void showFileProperties() {
        System.out.println("File Name: " + textFile.getName());
        System.out.println("Path: " + textFile.getAbsolutePath());
        System.out.println("Size: " + textFile.length() + " bytes");
        System.out.println("Last Modified: " + new Date(textFile.lastModified()));
    }
}
