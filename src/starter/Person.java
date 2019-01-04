package starter;

public class Person implements IPerson {
    private int id;
    private String firstName;
    private String lastName;

    Person(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private int incrementId() {
        return ++id;
    }

    protected void changeId() {
        System.out.println(incrementId());
    }
}
