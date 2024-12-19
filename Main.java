public class Main {
    public static void main(String[] args) {
        // Create objects for testing
        Course javaCourse = new Course("C101", "Java Basics", "Intro to Java", "Programming");
        Student student = new Student("S001", "Alice");
        Lecturer lecturer = new Lecturer("L001", "Prof. John");
        AItutor aiTutor = new AItutor();
        AIgrader aiGrader = new AIgrader();

        // Enroll student in course
        student.enrollCourse(javaCourse);

        // Lecturer adds a lecture
        lecturer.addLecture("Introduction to Java");

        // Student submits an assignment
        student.submitAssignment("Java Assignment #1");

        // AI Tutor processes a question
        aiTutor.processQuestion("What is polymorphism?");
        AItutor.generateResponse();

        // AI Grader grades the assignment
        AIgrader.gradeAssignment("Java Assignment #1");
        Aigrader.generateFeedback();
    }
}
