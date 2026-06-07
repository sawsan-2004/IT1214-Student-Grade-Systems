import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		System.out.println("Updated search feature");

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Mark");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
			 switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(id, name, marks));
					 System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No Students Found.");
                    } else {
                        for (Student s : students) {
                            s.displayStudent();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.getStudentId() == searchId) {
                            s.displayStudent();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {System.out.println("Student Not Found!");
                    }
                    break;

                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No Students Available.");
                    } else {
                        double total = 0;

                        for (Student s : students) {
                            total += s.getMarks();
                        }

                        double average = total / students.size();

                        System.out.println("Average Mark = " + average);
                    }
                    break;

                case 5:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice!");}

        } while (choice != 5);

        sc.close();
    }
}

