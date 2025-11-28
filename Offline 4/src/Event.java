/* This class stores the following information about an event: name, starting date, location and list of students registered for the event. */
public class Event {
    private String eventName;
    private String eventDate; // store in the format YYYY-MM-DD
    private String eventLocation;
    private Student[] registeredStudents;
    int participantsAdded = 0; //variable to keep track of number of participants so far added

    //Task: Write code for the constructor below to initialize the member variables properly
    public Event(String eventName, String eventDate, String eventLocation, int maximumParticipants) {
        //write your code here
    }

    // Task: Write getters and setters for Event attributes as required
    
    
    // Task: Write your code for the function below. This functions adds a participant to this event. Check for the following cases: (i) total participant count does not exceed the maximum participant count, (ii) the studentId is not already added.
    public void addParticipant(Student student) {
        // write your code here        
    }

    
    //Task: Write code for the function below. This function shows the details of an event. Make sure your output matches with the supplied sample output.
    public void showDetails() {
        //Write your code here
    }

    //Task: Write code for the function below. This function check whether the studentId in the argument has registered for this event or not. Return true if registered, otherwise return false.
    public boolean isRegistered(String studentId) {
        //Write your code here        
        return false;
    }

    // Task: Write code for the function below. This function removes a participant from this event. Check for the following cases: (i) the student Id is not regiseterd. 
    public void removeParticipant(String studentId) {
        //Write your code here
    }

}