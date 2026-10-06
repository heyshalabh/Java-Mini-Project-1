package studentmanagement;

import java.util.ArrayList;
import java.util.Scanner;

// Manager class
public class StudentManager {

    // ArrayList stores Student objects
    private ArrayList<Student> students = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    // Add Student
    public void addStudent() {

        System.out.println("\n========== ADD STUDENT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        // Check duplicate roll number
        if (findStudent(rollNumber) != null) {
            System.out.println("Student with this roll number already exists.");
            return;
        }

        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Subject 1 Marks: ");
        double marks1 = scanner.nextDouble();

        System.out.print("Enter Subject 2 Marks: ");
        double marks2 = scanner.nextDouble();

        System.out.print("Enter Subject 3 Marks: ");
        double marks3 = scanner.nextDouble();

        Student student = new Student(
                rollNumber,
                name,
                age,
                department,
                marks1,
                marks2,
                marks3
        );

        students.add(student);

        System.out.println("\nStudent added successfully!");
    }

    // Search Student
    public void searchStudent() {

        System.out.println("\n========== SEARCH STUDENT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        Student student = findStudent(rollNumber);

        if (student != null) {
            System.out.println("Student Found!");
            student.displayDetails();
        } else {
            System.out.println("Student not found.");
        }
    }

    // Update Student
    public void updateStudent() {

        System.out.println("\n========== UPDATE STUDENT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        Student student = findStudent(rollNumber);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        scanner.nextLine();

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter New Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter New Subject 1 Marks: ");
        double marks1 = scanner.nextDouble();

        System.out.print("Enter New Subject 2 Marks: ");
        double marks2 = scanner.nextDouble();

        System.out.print("Enter New Subject 3 Marks: ");
        double marks3 = scanner.nextDouble();

        student.setName(name);
        student.setAge(age);
        student.setDepartment(department);
        student.setMarks(marks1, marks2, marks3);

        System.out.println("\nStudent updated successfully!");
    }

    // Delete Student
    public void deleteStudent() {

        System.out.println("\n========== DELETE STUDENT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        Student student = findStudent(rollNumber);

        if (student != null) {

            students.remove(student);

            Student.decreaseStudentCount();

            System.out.println("Student deleted successfully!");

        } else {
            System.out.println("Student not found.");
        }
    }

    // Display all students
    public void displayAllStudents() {

        System.out.println("\n========== ALL STUDENTS ==========");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student student : students) {
            student.displayDetails();
        }

        System.out.println("\nTotal Students: " + Student.getStudentCount());
    }

    // Calculate Grade
    public void calculateGrade() {

        System.out.println("\n========== CALCULATE GRADE ==========");

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        Student student = findStudent(rollNumber);

        if (student != null) {

            student.calculateGrade();

            System.out.println("Percentage: "
                    + String.format("%.2f", student.getPercentage()) + "%");

            System.out.println("Grade: " + student.getGrade());

        } else {
            System.out.println("Student not found.");
        }
    }

    // Generate Result
    public void generateResult() {

        System.out.println("\n========== GENERATE RESULT ==========");

        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();

        Student student = findStudent(rollNumber);

        if (student != null) {
            student.generateResult();
        } else {
            System.out.println("Student not found.");
        }
    }

    // Find student by roll number
    private Student findStudent(int rollNumber) {

        for (Student student : students) {

            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }

        return null;
    }
}