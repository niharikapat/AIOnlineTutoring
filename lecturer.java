import java.util.ArrayList;

public class lecturer {
    private String lecturerID;
    private String lecturerName;
    private ArrayList<Course> assignedCourses;
    private ArrayList<String> lectures; // Lista delle lezioni aggiunte
    private ArrayList<String> assignments; // Lista degli assignment aggiunti

    // Constructor
    public lecturer(String lecturerID, String lecturerName) {
        this.lecturerID = lecturerID;
        this.lecturerName = lecturerName;
        this.assignedCourses = new ArrayList<>();
        this.lectures = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public void setLecturerName(String lecturerName) {
        this.lecturerName = lecturerName;
    }

    public ArrayList<Course> getAssignedCourses() {
        return assignedCourses;
    }

    // Methods to manage courses and grading
    public void createCourse(String courseID, String courseName, String courseDescription, String focusArea) {
        Course newCourse = new Course(courseID, courseName, courseDescription, focusArea);
        assignedCourses.add(newCourse);
        System.out.println(lecturerName + " created course: " + courseName);
    }

    public void addLecture(String lecture) {
        lectures.add(lecture);
        System.out.println(lecturerName + " added lecture: " + lecture);
    }

    public void addAssignment(String assignment) {
        assignments.add(assignment);
        System.out.println(lecturerName + " added assignment: " + assignment);
    }

    public void gradeAssignments(String assignment, String grade) {
        System.out.println(lecturerName + " graded assignment " + assignment + " with grade: " + grade);
    }

    // Optional: Method to view all assignments
    public void viewAssignments() {
        System.out.println(lecturerName + "'s assignments: " + assignments);
    }

    // Optional: Method to view all lectures
    public void viewLectures() {
        System.out.println(lecturerName + "'s lectures: " + lectures);
    }

    @Override
    public String toString() {
        return "Lecturer ID: " + lecturerID + "\nLecturer Name: " + lecturerName +
               "\nAssigned Courses: " + assignedCourses + "\nLectures: " + lectures +
               "\nAssignments: " + assignments;
    }
}
