import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Generate Report");
            System.out.println("7. Backup Records");
            System.out.println("8. Show File Properties");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = sc.nextDouble();
                    manager.addStudent(new Student(id, name, dept, gpa));
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextLine();
                    Student s = manager.searchById(id);
                    System.out.println(s != null ? s : "Not Found");
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter New Department: ");
                    dept = sc.nextLine();
                    System.out.print("Enter New GPA: ");
                    gpa = sc.nextDouble();
                    boolean updated = manager.updateStudent(id, name, dept, gpa);
                    System.out.println(updated ? "Updated Successfully" : "Student Not Found");
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    id = sc.nextLine();
                    boolean deleted = manager.deleteStudent(id);
                    System.out.println(deleted ? "Deleted Successfully" : "Student Not Found");
                    break;
                case 5:
                    manager.displayAll();
                    break;
                case 6:
                    manager.generateReport();
                    break;
                case 7:
                    manager.backup();
                    break;
                case 8:
                    manager.showFileProperties();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
