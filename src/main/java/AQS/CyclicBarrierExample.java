package AQS;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author 86138
 *演示AQS组件之CyclicBarrier的使用
 * 线程之间相互等待,达到一定数目条件一起运行
 */
public class CyclicBarrierExample {

    static Logger log = Logger.getLogger("info");
    private static CyclicBarrier barrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {

                }
            });
        }
        executor.shutdown();
    }

    private  static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info(threadNum+"::is ready" );
        barrier.await();
        log.info(threadNum+"::continue");
    }
}
