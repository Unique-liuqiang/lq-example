/*
package AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

*/
/**
 * @author 86138
 * 演示AQS组件中信号量的使用
 * 控制同时(运行)并发线程的个数
 *//*

@Slf4j
public class SemaphoreExample {
   static Logger log = Logger.getLogger("lavasoft");
    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    // 尝试获取一个许可
                    if (semaphore.tryAcquire(10000, TimeUnit.MILLISECONDS)) {
                        test(threadNum);
                        semaphore.release(); // 释放一个许可
                    }
                } catch (Exception e) {
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception {
         log.info(threadNum+"");
         Thread.sleep(1000);
    }
}
*/
