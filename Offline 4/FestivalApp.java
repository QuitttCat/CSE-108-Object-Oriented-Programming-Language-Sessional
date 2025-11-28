import java.util.Scanner;

/* This is the driver class for this project. You need to run this class with three command line arguments corresponding to the name, starting date and maxinum number of allowed events of a festival. For exmaple run the below command from the termincal:
java FestivalApp "CSE Fest 2023" "2023-07-15" 10*/
public class FestivalApp {

    public static void main(String[] args) {
        // Task: The program will be run with three command line arguements related to a festival- (i) the festival's name, (ii) its starting date and (iii) the maximum number of events allowed in the festival. Create a FestivalManager object named 'festivalManager' and initialize it with the values passed from the command line as: FestivalManager festivalManager = new FestivalManager(...); Generate error if the required parameters are not passed from the command line. 

        FestivalManager festivalManager=new FestivalManager(args[0],args[1],Integer.parseInt(args[2]));
        //FestivalManager festivalManager=new FestivalManager("CSE Fest 2023","2023-07-20",10);
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            // the following lines of code show a menu to take user's choice
            System.out.println("Menu:");
            System.out.println("1. Add an event");
            System.out.println("2. Register student in an event");
            System.out.println("3. View festival details");
            System.out.println("4. View specific event");
            System.out.println("5. View Event on Date");
            System.out.println("6. View event with maximum participants");
            System.out.println("7. View events for students");
            System.out.println("8. Cancel registration");
            System.out.println("9. Exit");
            System.out.print("Enter option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1: // Add an event
                    /*
                     * Task: using the scanner object, read the following information for an event:
                     * (i) name as a string, (ii) starting date as a string in 'YYYY-MM-DD' format,
                     * (iii) location as  astring, and (iv) max number of participants allowed in the
                     * event as an integer. Invoke the function 'add event' of 'Festival Manager' to
                     * add the event, i.e., call festivalManager.addEvent(...)
                     */
                    System.out.print("Enter event name: ");
                    String eventName=scanner.nextLine();
                    System.out.print("Enter event date: ");
                    String eventDate=scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String eventLocation=scanner.nextLine();
                    System.out.print("Enter maximum participants: ");
                    int maxParticipants= scanner.nextInt();
                    Event event=new Event(eventName,eventDate,eventLocation,maxParticipants);
                    festivalManager.addEvent(event);

                    break;

                case 2:// Register a student in an event
                    /*
                     * Task: read the name and id of a student and an event name. Then register the
                     * student in the event by calling the function:
                     * festivalManager.registerStudent(...)
                     */
                    System.out.print("Enter student name: ");
                    String studentName=scanner.nextLine();
                    System.out.print("Enter student id: ");
                    String studentId=scanner.nextLine();
                    System.out.print("Enter event name: ");
                    String eventName2=scanner.nextLine();
                    Student student=new Student(studentName,studentId);
                    festivalManager.registerStudent(eventName2,student);

                    break;

                case 3: // View festival details

                    festivalManager.showDetails();

                    break;

                case 4: // View event details
                    /*
                     * Task: read the name of an event and then show the details for the event by
                     * calling the function: festivalManager.showEvent(...);
                     */

                    System.out.print("Enter event name");
                    String eventName3=scanner.nextLine();
                    festivalManager.showEvent(eventName3);

                    break;
                case 5:
                    System.out.print("Enter event date: ");
                    String eventDate2=scanner.nextLine();
                    festivalManager.showEventsOnDate(eventDate2);
                    break;

                case 6: // View event with maximum participants
                    festivalManager.eventWithHighestParticipants();
                    break;

                case 7: // View events for students
                    /*Task: read the id of a student and then show the events the student is participating in by calling the function:  festivalManager.showEventsForStudent(...);*/
                    System.out.print("Enter student id: ");
                    String studentId2=scanner.nextLine();
                    festivalManager.showEventsForStudent(studentId2);

                    break;

                case 8: // Cancel registration
                    /* Task: read the id of a student and an event name. Then remove the student from the participant list of the event by calling the function:  festivalManager.cancelRegistration(...); */

                    System.out.print("Enter student id: ");
                    String studentId3=scanner.nextLine();
                    System.out.print("Enter event name: ");
                    String eventName4=scanner.nextLine();
                    festivalManager.cancelRegistration(eventName4,studentId3);

                    break;

                case 9:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        } while (choice != 9);

        scanner.close();
    }
}
