package App;

import Controller.StudentController;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentController controller = new StudentController();
        boolean continueApp = true;

        while (continueApp) {

            System.out.println("\n===== STUDENT CRUD MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

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

                default:
                    System.out.println("Invalid choice!");
            }


            continueApp = askToContinue(sc);
        }

        System.out.println("Thank you! Application exited.");
        sc.close();
    }


    private static boolean askToContinue(Scanner sc) {
        char choice;

        while (true) {
            System.out.print("\nPress Y to continue or N to exit: ");
            choice = sc.next().toUpperCase().charAt(0);

            if (choice == 'Y') {
                return true;
            } else if (choice == 'N') {
                return false;
            } else {
                System.out.println("Invalid choice. Please press Y or N.");
            }
        }
    }
}
