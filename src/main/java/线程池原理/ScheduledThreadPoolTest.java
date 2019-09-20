package 线程池原理;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *演示调度线程池的原理及使用
 */
public class ScheduledThreadPoolTest
{
    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        for(int i=0;i<10;i++){
            int temp=i;
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                  /*  try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/
                    System.out.println(Thread.currentThread().getName()+":"+temp);
                }
            },3, TimeUnit.SECONDS);
        }
    }
}
