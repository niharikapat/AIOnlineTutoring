import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecturers")
public class LecturerController {

    private final LecturerService lecturerService;

    // Constructor injection for the service
    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    // Endpoint to create a course
    @PostMapping("/createCourse")
    public ResponseEntity<ApiResponse> createCourse(@RequestBody Course course) {
        if (course == null || course.getCourseID() == null || course.getCourseName() == null) {
            return new ResponseEntity<>(new ApiResponse("Course details are incomplete", "error"), HttpStatus.BAD_REQUEST);
        }
        String result = lecturerService.createCourse(course);
        return new ResponseEntity<>(new ApiResponse(result, "success"), HttpStatus.CREATED);
    }

    // Endpoint to add a lecture
    @PostMapping("/addLecture")
    public ResponseEntity<ApiResponse> addLecture(@RequestParam String lecture) {
        if (lecture == null || lecture.trim().isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Lecture cannot be empty", "error"), HttpStatus.BAD_REQUEST);
        }
        String result = lecturerService.addLecture(lecture);
        return new ResponseEntity<>(new ApiResponse(result, "success"), HttpStatus.OK);
    }

    // Endpoint to grade an assignment
    @PostMapping("/gradeAssignment")
    public ResponseEntity<ApiResponse> gradeAssignment(@RequestParam String assignment, @RequestParam String grade) {
        if (assignment == null || assignment.trim().isEmpty() || grade == null || grade.trim().isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Assignment and grade must be provided", "error"), HttpStatus.BAD_REQUEST);
        }
        String result = lecturerService.gradeAssignment(assignment, grade);
        return new ResponseEntity<>(new ApiResponse(result, "success"), HttpStatus.OK);
    }

    // Global exception handler for unexpected errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleException(Exception e) {
        return new ResponseEntity<>(new ApiResponse("Error: " + e.getMessage(), "error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
