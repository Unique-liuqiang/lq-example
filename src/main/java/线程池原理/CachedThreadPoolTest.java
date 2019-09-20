package 线程池原理;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示缓存线程池的原理及运用
 */
public class CachedThreadPoolTest {
    public static void main(String[] args){
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

       for(int i=0;i<10;i++){
           int temp=i;
           newCachedThreadPool.execute(new Runnable() {
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
