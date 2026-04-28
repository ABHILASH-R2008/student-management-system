import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n1.Add Student\n2.Search Student\n3.Delete Student\n4.View All Students\n5.Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    students.add(new Student(id, name, marks));
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    int searchid = sc.nextInt();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.id == searchid) {
                            s.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found");
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteid = sc.nextInt();

                    boolean deleted = students.removeIf(s -> s.id == deleteid);

                    if (deleted) {
                        System.out.println("Student deleted successfully");
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 4:
                    if (students.isEmpty()) {
                        System.out.println("No students available");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Program Terminated");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 5);

        sc.close();
    }
}