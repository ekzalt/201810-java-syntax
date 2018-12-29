package patterns.proxy;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Proxy;

public class DatingService {
    private IPerson getPerson(String name) {
        IPerson person = new Person();
        person.setName(name);
        return person;
    }

    @NotNull
    private IPerson getProxyOwner(IPerson person) {
        return (IPerson) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new InvocationOwner(person));
    }

    @NotNull
    private IPerson getProxyNonOwner(IPerson person) {
        return (IPerson) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new InvocationNonOwner(person));
    }

    public void run() {
        IPerson personJoe = getPerson("Joe");
        IPerson ownerJoe = getProxyOwner(personJoe);
        IPerson nonOwnerJoe = getProxyNonOwner(personJoe);

        try {
            // owner can set his own person info
            ownerJoe.setGender("male");
            ownerJoe.setInterests("game");

            // non owner can set rating for others
            nonOwnerJoe.setRating(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n" + personJoe.getName() + " " + personJoe.getGender() + " " + personJoe.getRating() + "\n");
    }
}
