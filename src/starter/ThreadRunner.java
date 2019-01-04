package starter;

// потоки в java через интерфейс
public class ThreadRunner implements Runnable {
    private void printFor() {
        for (int i = 0; i < 10; i++) System.out.println("Thread runner " + i);
    }

    // надо имплементировать метод run
    public void run() {
        // выполняем что-то "полезное"
        printFor();
    }
}
