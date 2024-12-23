import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aigrader")
public class AIGraderController {

    private final AIGraderService aiGraderService;

    @Autowired
    public AIGraderController(AIGraderService aiGraderService) {
        this.aiGraderService = aiGraderService;
    }

    // Endpoint to grade an assignment
    @PostMapping("/gradeAssignment")
    public ResponseEntity<ApiResponse> gradeAssignment(@RequestParam String assignment) {
        // Validate input
        if (assignment == null || assignment.trim().isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Assignment cannot be empty", "error"), HttpStatus.BAD_REQUEST);
        }

        // Process the assignment grading
        String result = aiGraderService.gradeAssignment(assignment);

        // Return success response
        return new ResponseEntity<>(new ApiResponse("Grading assignment: " + assignment, result, true), HttpStatus.OK);
    }

    // Endpoint to generate feedback
    @PostMapping("/generateFeedback")
    public ResponseEntity<ApiResponse> generateFeedback() {
        // Process feedback generation
        String feedback = aiGraderService.generateFeedback();

        // Return feedback response
        return new ResponseEntity<>(new ApiResponse("Feedback generated", feedback, true), HttpStatus.OK);
    }

    // Global exception handler for the controller
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        return new ResponseEntity<>(new ApiResponse("Error: " + e.getMessage(), "error", false), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
