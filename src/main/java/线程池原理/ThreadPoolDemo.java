package 线程池原理;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示线程池的使用及原理
 */
public class ThreadPoolDemo {
    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(3));

        threadPoolExecutor.execute(new TaskThread("任务1"));
        threadPoolExecutor.execute(new TaskThread("任务2"));
        threadPoolExecutor.execute(new TaskThread("任务3"));
        //任务4 放在缓存队列中
        threadPoolExecutor.execute(new TaskThread("任务4"));
        //任务5 创建新线程,达到最大线程数
        threadPoolExecutor.execute(new TaskThread("任务5"));
        //任务6 拒绝策略
        threadPoolExecutor.execute(new TaskThread("任务6"));

    }
}

class  TaskThread implements Runnable{

    private String taskName;

    public TaskThread(String taskName){
        this.taskName=taskName;
    }

    @Override
    public void run() {
          System.out.println(Thread.currentThread().getName()+":"+taskName);
    }
}