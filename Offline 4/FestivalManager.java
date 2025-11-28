/* This class stores information of a festival which are name, starting date and list of events that will take place during the festival. */
public class FestivalManager {
    private String name;
    private String startDate;
    private Event[] events;
    private int eventsAdded = 0;
    private int maxEventCount;
    //Task: Write code for the constructor below to initialize the member variables properly
    public FestivalManager(String name, String startDate, int maxEventCount) {
        this.name=name;
        this.startDate=startDate;
        events=new Event[maxEventCount];
        this.maxEventCount=maxEventCount;
    }

    public int getEventsAdded() {
        return eventsAdded;
    }

    public int getMaxEventCount() {
        return maxEventCount;
    }

    //Task: Write code for the function below. This function adds an event to this festival. Check for the following case: (i) total event count does not exceed the maximum number of events allowed for this festival
    public void addEvent(Event e) {
        if(isEventExist(e.getEventName())) {
            System.out.println();
            System.out.println("Event already added!");
        }
        else if(eventsAdded==maxEventCount) {
            System.out.println();
            System.out.println("Maximum event limit reached!");
        }
        else {
            events[eventsAdded++]=e;
            System.out.println();
            System.out.println("Event added successfully!");
        }
        return;
    }

    //Task: Write code for the function below. This function registers a student for an event in this festival. Check for the following case: (i) event does not exist
    public void registerStudent(String eventName, Student s) {
        if(!isEventExist(eventName)) return;
        else
        {
            int eventIndex=0;
            for (int i=0;i<eventsAdded;i++)
            {
                if(events[i].getEventName().equals(eventName)) eventIndex=i;
            }
            events[eventIndex].addParticipant(s);
        }
    }

    // Task: Write code for the function below. The function shows the details of this festival. Make sure the output matches with the supplied sample output.
    public void showDetails() {
        System.out.println();
        System.out.println("Festival Name: "+name);
        System.out.println("Festival Starting Date: "+startDate);
        System.out.println("Festival Events:");
        for(int i=0;i<eventsAdded;i++)
            events[i].showDetails();

    }

    // Task: Write code for the function below. This function shows details of the event in the argument. Check for the following case: (i) event does not exist
    public void showEvent(String eventName) {
        if(!isEventExist(eventName)){
            System.out.println();
            System.out.println("No such event!");
        }
        else
        {
            int eventIndex=0;
            for (int i=0;i<eventsAdded;i++)
            {
                if(events[i].getEventName().equals(eventName)) eventIndex=i;
            }
            System.out.println();
            events[eventIndex].showDetails();
        }
        return;

    }

    // Task: Write code for the function below. This function shows details of the events that will start on the date passed as its argument. Check for the following case: (i) event does not exist
    public void showEventsOnDate(String eventDate) {
        System.out.println();
        System.out.println("Events on "+eventDate+" are:");
     for (int i=0;i<eventsAdded;i++)
     {
         if(events[i].getEventDate().equals(eventDate))
             System.out.println(events[i].getEventName());
     }

    }

    //Task: Write code for the function below. This function shows the details of the events with maximum number of participants. If there are multiple events, show all.
    public void eventWithHighestParticipants() {
        System.out.println();
        System.out.println("Event with highest participants:");
        int highestParticipants=0;
        for(int i=0;i<eventsAdded;i++)
        {
            if(events[i].getParticipantsAdded()>=highestParticipants)
                highestParticipants=events[i].getParticipantsAdded();
        }
        for(int i=0;i<eventsAdded;i++)
        {
            if(events[i].getParticipantsAdded()==highestParticipants)
                events[i].showDetails();
        }

    }

    //Task: Write code for the function below. This function takes a student Id as input and then lists all the events this particular student has registered for. Make sure your output matches the supplied sample output.
    public void showEventsForStudent(String studentId) {
        System.out.println();
        System.out.println("Student "+studentId+" is registered in :");
        for(int i=0;i<eventsAdded;i++)
        {
            if(events[i].isRegistered(studentId))
                System.out.println(events[i].getEventName());
        }

    }

    //Task: Write code for the function below. This functions takes an event's name and a student's ID as arguments and then removes the student from the registered student list of the event. Check for the following cases: (i) event does not exist, (ii) student is not registered for the event
    public void cancelRegistration(String eventName, String studentId) {
        if(!isEventExist(eventName)) {
            System.out.println();
            System.out.println("This event doesn't exist!");
        }
        else
        {
            int eventIndex=0;
            for (int i=0;i<eventsAdded;i++)
            {
                if(events[i].getEventName().equals(eventName)) eventIndex=i;
            }
            events[eventIndex].removeParticipant(studentId);
        }


    }
    public boolean isEventExist(String event) {
        for(int i=0;i<eventsAdded;i++)
            if(events[i].getEventName().equals(event)) return true;
        return false;
    }
}
