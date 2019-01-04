package starter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// BlockingQueue from java.util.concurrent

// блокировщик ресурса для многопоточных систем поставщиков/потребителей
public class ResourceLocker {
    Object resource = null;
    ReentrantLock locker = new ReentrantLock();
    Condition pushed = locker.newCondition();
    Condition pulled = locker.newCondition();

    public void push(Object object) throws InterruptedException {
        try {
            locker.lock();

            while (resource != null) pulled.await();

            resource = object;
            pushed.signalAll();
        } finally {
            locker.unlock();
        }
    }

    public synchronized Object pull() throws InterruptedException {
        try {
            locker.lock();

            while (resource == null) pushed.await();

            Object result = resource;
            resource = null;
            pulled.signalAll();

            return result;
        } finally {
            locker.unlock();
        }
    }
}
