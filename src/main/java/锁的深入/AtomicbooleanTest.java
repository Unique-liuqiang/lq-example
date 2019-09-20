package 锁的深入;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 86138
 * 该示例演示AtomicBoolean,Semaphore(信号量),CountDownLatch(用途等待其他线程执行完),
 */
public class AtomicbooleanTest {
    private static  AtomicBoolean isHappened =new AtomicBoolean(false);

    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore=new Semaphore(threadTotal);
        CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
      for(int i = 0; i < clientTotal ; i++) {
          executorService.execute(() -> {
              try {
                  semaphore.acquire();//控制有多少个线程并发执行
                  test();
                  System.out.println("线程的名字:"+Thread.currentThread().getName());
                  semaphore.release();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              countDownLatch.countDown();//-1操作
          });
      }
        countDownLatch.await();//不为0一直阻塞
        executorService.shutdown();
        System.out.println(isHappened.get());
    }


    private static void test() {
        if (isHappened.compareAndSet(false, true)) {
            System.out.println("执行了");
        }
    }
}
