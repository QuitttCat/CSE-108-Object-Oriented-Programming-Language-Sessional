/* This class stores some basic information of a student, namely a student's name and id.  */
public class Student {
    private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    

    public void showDetails() {
        System.out.println("  Name: "+name+", Id: "+id);
    }
}
