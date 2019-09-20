package 锁的深入;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 86138
 * 演示读写锁的使用
 */
public class ReentrantReadWriteLockTest {

    static Map<String,Object> map=new HashMap<>();

    static ReentrantReadWriteLock  rwl =  new ReentrantReadWriteLock();

    //写锁
    static Lock w = rwl.writeLock();

    //读锁
    static Lock r = rwl.readLock();


    //读操作
    public static   Object get(String key) {
        try {
            r.lock();
            System.out.println("正在做读的操作,key:" + key + " 开始");
            Thread.sleep(0);
            Object object = map.get(key);
            System.out.println("正在做读的操作,key:" + key + " 结束");
            return object;
        } catch (InterruptedException e) {

        } finally {
            r.unlock();
        }
        return key;
    }

    //写操作
    public static  Object put(String key, Object value) {
        try {
            w.lock();
            System.out.println("正在做写的操作,key:" + key + ",value:" + value + "开始.");
            Thread.sleep(100);
            Object object = map.put(key, value);
            System.out.println("正在做写的操作,key:" + key + ",value:" + value + "结束.");
            return object;
        } catch (InterruptedException e) {

        } finally {
            w.unlock();
        }
        return value;
    }
    
    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ReentrantReadWriteLockTest.put(i + "", i + "");
                }

            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    ReentrantReadWriteLockTest.get(i + "");
                }

            }
        }).start();
    }

}

