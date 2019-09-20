package 锁的深入;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 86138
 * 演示可重入锁
 * 演示锁可以传递,方法递归传递
 */
public class ReentrantLockTest  extends  Thread{

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();

    }
    
    public void set() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName());
            set();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args){
        ReentrantLockTest ss = new ReentrantLockTest();
        new Thread(ss,"线程一").start();
        new Thread(ss,"线程二").start();
    }

}

