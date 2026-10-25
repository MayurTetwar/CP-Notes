package Design;

import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.*;

class Concurrency{
    public static void main(String[] args) {
        
        // 1. Synchronization classes
        Semaphore semaphore = new Semaphore(5);
        // Controls access using permits; useful for limiting concurrent access and implementing blocking queues.
        // if the system have "capacity" to hold the resouces (limited resouces to hold) then used this semaphores.
        ReentrantLock mutex = new ReentrantLock();
        mutex.lock();
        mutex.unlock();
        // Provides mutual exclusion, similar to a mutex.
        // for only 1 thread at a time to perform the certain opration
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        // Protecting multiple related data structures together
        Lock readlock = lock.readLock();
        Lock writeLock = lock.writeLock();


        // 2. Thread-safe collections
        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        // Thread-safe map with high concurrency
        Set<Integer> set = ConcurrentHashMap.newKeySet();
        // Thread-safe set
        List<Integer> list = new CopyOnWriteArrayList<>();
        // Thread-safe list; copies the underlying array on modifications
        Queue<Integer> q = new ConcurrentLinkedQueue<>();
        // Thread-safe, non-blocking queue
        Deque<Integer> dq = new ConcurrentLinkedDeque<>();
        // Thread-safe, non-blocking double-ended queue
    }

}