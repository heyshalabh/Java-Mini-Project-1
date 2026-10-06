package studentmanagement;

// Student inherits Person and implements ResultOperations
public class Student extends Person implements ResultOperations {

    // Private data members
    private int rollNumber;
    private String department;

    private double marks1;
    private double marks2;
    private double marks3;

    private char grade;
    private double percentage;

    // Static member
    private static int studentCount = 0;

    // Constructor
    public Student(int rollNumber, String name, int age,
                   String department, double marks1,
                   double marks2, double marks3) {

        // Calling parent class constructor
        super(name, age);

        this.rollNumber = rollNumber;
        this.department = department;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;

        studentCount++;

        calculateGrade();
    }

    // Method Overloading - constructor-like alternative method
    public Student(int rollNumber, String name, int age) {
        this(rollNumber, name, age, "CSE", 0, 0, 0);
    }

    // Getters
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPercentage() {
        return percentage;
    }

    public char getGrade() {
        return grade;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMarks(double marks1, double marks2, double marks3) {
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;

        calculateGrade();
    }

    // Method Overloading
    public void setMarks(double marks) {
        this.marks1 = marks;
        this.marks2 = marks;
        this.marks3 = marks;

        calculateGrade();
    }

    // Calculate percentage and grade
    @Override
    public void calculateGrade() {

        double total = marks1 + marks2 + marks3;

        percentage = total / 3;

        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else if (percentage >= 40) {
            grade = 'E';
        } else {
            grade = 'F';
        }
    }

    // Generate result
    @Override
    public void generateResult() {

        System.out.println("\n========== STUDENT RESULT ==========");
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Department  : " + department);

        System.out.println("------------------------------------");
        System.out.println("Subject 1 Marks : " + marks1);
        System.out.println("Subject 2 Marks : " + marks2);
        System.out.println("Subject 3 Marks : " + marks3);

        System.out.println("------------------------------------");
        System.out.printf("Percentage  : %.2f%%\n", percentage);
        System.out.println("Grade       : " + grade);

        if (grade == 'F') {
            System.out.println("Result      : FAIL");
        } else {
            System.out.println("Result      : PASS");
        }

        System.out.println("====================================");
    }

    // Display complete student details
    public void displayDetails() {

        System.out.println("\n------------------------------------");
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Department  : " + department);
        System.out.println("Marks 1     : " + marks1);
        System.out.println("Marks 2     : " + marks2);
        System.out.println("Marks 3     : " + marks3);
        System.out.printf("Percentage  : %.2f%%\n", percentage);
        System.out.println("Grade       : " + grade);
        System.out.println("------------------------------------");
    }

    // Static method
    public static int getStudentCount() {
        return studentCount;
    }

    // Used when deleting a student
    public static void decreaseStudentCount() {
        if (studentCount > 0) {
            studentCount--;
        }
    }
}