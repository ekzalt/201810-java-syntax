package patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvocationNonOwner implements InvocationHandler {
    private IPerson person;

    public InvocationNonOwner(IPerson person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().startsWith("get")) return method.invoke(person, args);
            else if (method.getName().equals("setRating")) return method.invoke(person, args);
            else if (method.getName().startsWith("set")) throw new IllegalAccessException();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
