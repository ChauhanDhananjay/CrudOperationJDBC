package App;

import Controller.StudentController;

import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        StudentController controller = new StudentController();
        do {
            System.out.println("\n===== STUDENT CRUD MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    controller.addStudent(id, name, age);
                    break;

                case 2:
                    controller.viewAllStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    controller.viewStudentById(id);
                    break;

                case 4:
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    System.out.print("New Name: ");
                    name = sc.next();
                    System.out.print("New Age: ");
                    age = sc.nextInt();
                    controller.updateStudent(id, name, age);
                    break;

                case 5:
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    controller.deleteStudent(id);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        }while (choice != 6);

        sc.close();
    }
}
