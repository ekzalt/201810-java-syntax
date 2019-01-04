package starter;

// наследуемся
public class Developer extends Person {
    Developer(int id, String firstName, String lastName) {
        // и вызываем super родителя
        super(id, firstName, lastName);
    }

    public void develop(String task) {
        System.out.println("develop task: " + task);
    }

    // переопределяем родительский метод
    @Override
    protected void changeId() {
        System.out.println(getId() + 2);
    }
}
