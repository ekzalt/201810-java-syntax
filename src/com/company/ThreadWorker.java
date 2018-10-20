package com.company;

// потоки в java через наследование
public class ThreadWorker extends Thread {
    private void printFor() {
        for (int i = 0; i < 10; i++) System.out.println("Thread worker " + i);
    }

    @Override
    public void run() {
        // выполняем что-то "полезное"
        printFor();
    }
}
