package studentmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        int choice;

        do {

            System.out.println("\n");
            System.out.println("========================================");
            System.out.println("       STUDENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display Student Details");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Generate Result");
            System.out.println("8. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    manager.addStudent();
                    break;

                case 2:
                    manager.searchStudent();
                    break;

                case 3:
                    manager.updateStudent();
                    break;

                case 4:
                    manager.deleteStudent();
                    break;

                case 5:
                    manager.displayAllStudents();
                    break;

                case 6:
                    manager.calculateGrade();
                    break;

                case 7:
                    manager.generateResult();
                    break;

                case 8:
                    System.out.println("\nThank you for using Student Management System!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 8);

        scanner.close();
    }
}