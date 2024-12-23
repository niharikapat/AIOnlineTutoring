import java.util.ArrayList;

public class Course {
    private String courseID;
    private String courseName;
    private String courseDescription;
    private String focusArea;
    private ArrayList<Lecturer> lecturers; // Association with Lecturer class
    private ArrayList<String> assignments; // List of assignments

    // Constructor
    public Course(String courseID, String courseName, String courseDescription, String focusArea) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.focusArea = focusArea;
        this.lecturers = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    // Getter and Setter methods
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getFocusArea() {
        return focusArea;
    }

    public void setFocusArea(String focusArea) {
        this.focusArea = focusArea;
    }

    public ArrayList<Lecturer> getLecturers() {
        return lecturers;
    }

    public ArrayList<String> getAssignments() {
        return assignments;
    }

    // Methods to manage lecturers and assignments
    public void addLecture(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public void addAssignment(String assignment) {
        assignments.add(assignment);
        System.out.println("Assignment added: " + assignment);
    }

    public void removeLecture(Lecturer lecturer) {
        lecturers.remove(lecturer);
    }

    public void removeAssignment(String assignment) {
        if (assignments.remove(assignment)) {
            System.out.println("Assignment removed: " + assignment);
        } else {
            System.out.println("Assignment not found: " + assignment);
        }
    }

    @Override
    public String toString() {
        return "Course ID: " + courseID +
               "\nCourse Name: " + courseName +
               "\nDescription: " + courseDescription +
               "\nFocus Area: " + focusArea +
               "\nLecturers: " + lecturers +
               "\nAssignments: " + assignments;
    }
}
