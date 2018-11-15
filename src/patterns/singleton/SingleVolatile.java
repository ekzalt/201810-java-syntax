package patterns.singleton;

/*
Вариант 3: использовать "условную блокировку"
(volatile + synchronized). Поправленный и ускоренный synchronized.
Поддержка Java 5+
 */

public class SingleVolatile {
    // шаг 1
    private volatile static SingleVolatile instance;

    private SingleVolatile() {}

    public static synchronized SingleVolatile getInstance() {
        if (instance == null) {
            // шаг 2
            synchronized (SingleVolatile.class) {
                if (instance == null) instance = new SingleVolatile();
            }
        }

        return instance;
    }

    public void getType() {
        System.out.println("I am volatile singleton");
    }
}
