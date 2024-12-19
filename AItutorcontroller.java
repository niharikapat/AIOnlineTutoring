
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aitutor")
public class AITutorController {

    private final AITutorService aiTutorService;

    // Constructor injection for the service
    @Autowired
    public AITutorController(AITutorService aiTutorService) {
        this.aiTutorService = aiTutorService;
    }

    // Endpoint to process the question
    @PostMapping("/processQuestion")
    public ResponseEntity<ApiResponse> processQuestion(@RequestParam String question) {
        if (question == null || question.trim().isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Question cannot be empty", "error"), HttpStatus.BAD_REQUEST);
        }
        String result = aiTutorService.processQuestion(question);
        return new ResponseEntity<>(new ApiResponse(result, "success"), HttpStatus.OK);
    }

    // Endpoint to generate response from the AI tutor
    @PostMapping("/generateResponse")
    public ResponseEntity<ApiResponse> generateResponse() {
        String result = aiTutorService.generateResponse();
        return new ResponseEntity<>(new ApiResponse(result, "success"), HttpStatus.OK);
    }

    // Global exception handler for unexpected errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        return new ResponseEntity<>(new ApiResponse("Error: " + e.getMessage(), "error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
