import java.util.*;
class Student {
    private int id;
    private String name;
    private String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Course: " + course);
    }
}
abstract class Course {
    String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    abstract void syllabus();  
}
class ITCourse extends Course {
    public ITCourse() {
        super("IT");
    }

    @Override
    void syllabus() {
        System.out.println("IT Syllabus: Java, DBMS, Web Development, OOP.");
    }
}
class EECCourse extends Course {
    public EECCourse() {
        super("EEC");
    }

    @Override
    void syllabus() {
        System.out.println("EEC Syllabus: Circuits, Machines, Power Systems, Electronics.");
    }
}
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== STUDENT COURSE SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Show Course Syllabus");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course (IT / EEC): ");
                    String course = sc.nextLine();

                    students.add(new Student(id, name, course));
                    System.out.println("Student Added Successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Student List ---");
                    for (Student s : students) {
                        s.display();
                    }
                    break;

                case 3:
                    System.out.print("Enter Course (IT / EEC): ");
                    String c = sc.nextLine();

                    Course obj;

                    if (c.equalsIgnoreCase("IT")) {
                        obj = new ITCourse();
                    } else {
                        obj = new EECCourse();
                    }

                    obj.syllabus();
                    break;

                case 4:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
