package 线程池原理;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示定长线程池的原理及运用
 */
public class FixedThreadPoolTest {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<10;i++){
            int temp=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+temp);
                }
            });
        }
    }
}
