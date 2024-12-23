public class AIGrader {

  // Method to simulate grading an assignment
  public void gradeAssignment(String assignment) {
      System.out.println("Grading assignment: " + assignment);

      // Simulate scoring the assignment (you can add more complex logic here)
      int score = evaluateAssignment(assignment);

      // Assign a grade based on the score
      String grade = assignGrade(score);

      // Generate feedback for the student
      generateFeedback(assignment, grade);
  }

  // Method to evaluate the assignment (using a simple rule for demonstration)
  private int evaluateAssignment(String assignment) {
      // For example, we base the score on the length of the assignment name
      int score = 0;
      if (assignment.length() > 10) {
          score = 80; // Good length
      } else {
          score = 50; // Short length
      }
      return score;
  }

  // Method to assign a grade based on the score
  private String assignGrade(int score) {
      if (score >= 90) {
          return "A";
      } else if (score >= 80) {
          return "B";
      } else if (score >= 70) {
          return "C";
      } else {
          return "F";
      }
  }

  // Method to generate feedback for the student
  private void generateFeedback(String assignment, String grade) {
      System.out.println("Feedback for assignment: " + assignment);
      System.out.println("Grade: " + grade);

      // Providing general feedback based on the grade
      if (grade.equals("A")) {
          System.out.println("Excellent work! Keep it up.");
      } else if (grade.equals("B")) {
          System.out.println("Good job, but there's room for improvement.");
      } else if (grade.equals("C")) {
          System.out.println("Fair attempt. Review the concepts and try again.");
      } else {
          System.out.println("Needs improvement. Please review the assignment and try again.");
      }
  }
}







