import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class studentcontroller {

    private final StudentService studentService;

    // Constructor injection for the service
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Endpoint to enroll in a course
    @PostMapping("/enrollCourse")
    public ResponseEntity<ApiResponse> enrollCourse(@RequestBody Course course) {
        if (course == null || course.getCourseID() == null || course.getCourseName() == null) {
            return new ResponseEntity<>(new ApiResponse("Course details are incomplete", "error"), HttpStatus.BAD_REQUEST);
        }
        String result = studentService.enrollCourse(course);
        return new ResponseEntity<>(new ApiResponse(result, "success"), HttpStatus.CREATED);
    }

    // Endpoint to submit an assignment
    @PostMapping("/submitAssignment")
    public ResponseEntity<ApiResponse> submitAssignment(@RequestParam String assignmentName) {
        if (assignmentName == null || assignmentName.trim().isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Assignment name cannot be empty", "error"), HttpStatus.BAD_REQUEST);
        }
        String result = studentService.submitAssignment(assignmentName);
        return new ResponseEntity<>(new ApiResponse(result, "success"), HttpStatus.OK);
    }

    // Global exception handler for unexpected errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        return new ResponseEntity<>(new ApiResponse("Error: " + e.getMessage(), "error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
