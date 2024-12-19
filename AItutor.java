import java.util.HashMap;
import java.util.Map;

public class AItutor {
    
    private Map<String, String> questionDatabase; // A simple database for question/response pairs
    
    // Constructor
    public AItutor() {
        // Initialize with some predefined responses
        questionDatabase = new HashMap<>();
        questionDatabase.put("What is Java?", "Java is a programming language.");
        questionDatabase.put("What is OOP?", "OOP stands for Object-Oriented Programming.");
        // Add more predefined questions and answers as needed
    }

    // Method to process questions
    public void processQuestion(String question) {
        System.out.println("Processing question: " + question);
        String response = generateResponse(question);
        System.out.println("Response: " + response);
    }

    // Method to generate a response based on the question
    public String generateResponse(String question) {
        // Check if the question exists in the database
        if (questionDatabase.containsKey(question)) {
            return questionDatabase.get(question);
        } else {
            return "I'm not sure about that. Let me get back to you.";
        }
    }

    // Method to provide feedback to the student
    public void provideFeedback(String studentResponse) {
        System.out.println("Providing feedback on response: " + studentResponse);
        
        // Simulate a basic feedback logic
        if (studentResponse.contains("Java")) {
            System.out.println("Good job! You seem to know Java.");
        } else {
            System.out.println("Let's go over this concept again.");
        }
    }
    
    // Optional: Method to add custom responses to the AI database
    public void addCustomResponse(String question, String response) {
        questionDatabase.put(question, response);
        System.out.println("Custom response added: " + question + " -> " + response);
    }
}
