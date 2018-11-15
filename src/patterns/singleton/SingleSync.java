package patterns.singleton;

/*
Вариант 1: использовать синхронизацию -
пагубно сказывается на производительности,
если getInstance() часто вызывается в многопоточном режиме.
 */

public class SingleSync {
    private static SingleSync instance;

    private SingleSync() {}

    public static synchronized SingleSync getInstance() {
        if (instance == null) instance = new SingleSync();

        return instance;
    }

    public void getType() {
        System.out.println("I am synchronized singleton");
    }
}
