/* This class stores the following information about an event: name, starting date, location and list of students registered for the event. */
public class Event {
    private String eventName;
    private String eventDate; // store in the format YYYY-MM-DD
    private String eventLocation;
    private Student[] registeredStudents;
    private int participantsAdded = 0; //variable to keep track of number of participants so far added
    private int maximumParticipants;
    //Task: Write code for the constructor below to initialize the member variables properly
    public Event(String eventName, String eventDate, String eventLocation, int maximumParticipants) {
       this.eventName=eventName;
       this.eventDate=eventDate;
       this.eventLocation=eventLocation;
       registeredStudents=new Student[maximumParticipants];
       this.maximumParticipants=maximumParticipants;
    }

    public int getMaximumParticipants() {
        return maximumParticipants;
    }

    public int getParticipantsAdded() {
        return participantsAdded;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    // Task: Write your code for the function below. This functions adds a participant to this event. Check for the following cases: (i) total participant count does not exceed the maximum participant count, (ii) the studentId is not already added.
    public void addParticipant(Student student) {
        if(isRegistered(student.getId())){
            System.out.println();
            System.out.println("Student already registered!");
        }
        else if(participantsAdded==maximumParticipants) {
            System.out.println();
            System.out.println("Maximum capacity exceeded!");
        }
        else{
            registeredStudents[participantsAdded++]=student;
            System.out.println();
            System.out.println("Student registration completed!");
        }
        return;
    }

    
    //Task: Write code for the function below. This function shows the details of an event. Make sure your output matches with the supplied sample output.
    public void showDetails() {
        System.out.println("Name: "+eventName);
        System.out.println("Date: "+eventDate);
        System.out.println("Location: "+eventLocation);
        for(int i=0;i<participantsAdded;i++)
            System.out.println("Name: "+registeredStudents[i].getName()+", Id: "+registeredStudents[i].getId());
        System.out.println();
    }

    //Task: Write code for the function below. This function check whether the studentId in the argument has registered for this event or not. Return true if registered, otherwise return false.
    public boolean isRegistered(String studentId) {
        for(int i=0;i<participantsAdded;i++)
            if(registeredStudents[i].getId().equals(studentId)) return true;
        return false;
    }

    // Task: Write code for the function below. This function removes a participant from this event. Check for the following cases: (i) the student Id is not regiseterd. 
    public void removeParticipant(String studentId) {
        if(!isRegistered(studentId)) {
            System.out.println();
            System.out.println("Student not registered!");
            return;
        }
        int removeIndex=0;
        for(int i=0;i<participantsAdded;i++)
        {
            if(registeredStudents[i].getId().equals(studentId)) removeIndex=i;
        }
        for(int i=removeIndex;i<participantsAdded-1;i++)
            registeredStudents[i]=registeredStudents[i+1];

        participantsAdded--;
        System.out.println();
        System.out.println("Successfully removed id "+studentId+" from event "+eventName);
    }

}