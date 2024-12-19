import java.util.ArrayList;


public class Student {
    private String studentID;
    private String studentName;
    private ArrayList<Course> enrolledCourses;
    private ArrayList<String> submittedAssignments; // Llist of assignment sent
    private ArrayList<String> grades; // List of grades

    // Constructor
    public Student(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
        this.submittedAssignments = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public ArrayList<String> getSubmittedAssignments() {
        return submittedAssignments;
    }

    public ArrayList<String> getGrades() {
        return grades;
    }

    // Methods to manage course enrollments and assignments
    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println(studentName + " enrolled in " + course.getCourseName());
    }

    public void dropCourse(Course course) {
        enrolledCourses.remove(course);
        System.out.println(studentName + " dropped " + course.getCourseName());
    }

    public void submitAssignment(String assignment) {
        submittedAssignments.add(assignment);
        System.out.println(studentName + " submitted assignment: " + assignment);
    }

    public void viewAssignments() {
        System.out.println(studentName + "'s submitted assignments: " + submittedAssignments);
    }

    public void viewGrades() {
        System.out.println(studentName + "'s grades: " + grades);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nStudent Name: " + studentName +
               "\nEnrolled Courses: " + enrolledCourses + "\nSubmitted Assignments: " + submittedAssignments +
               "\nGrades: " + grades;
    }
}
