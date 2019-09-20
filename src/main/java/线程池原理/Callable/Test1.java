package 线程池原理.Callable;

import java.util.concurrent.*;

/**
 * @author 86138
 * 演示Callable接口,futcure模式
 */
public class Test1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Object> submit = executorService.submit(new TaskCallable());
        System.out.println("主线程开始执行...");
        //此线程为接收数据
       executorService.execute(new Runnable() {
           @Override
           public void run() {
               try {
                   Object o = submit.get();
                   System.out.println("result:"+o);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (ExecutionException e) {
                   e.printStackTrace();
               }
           }
       });
        System.out.println("主线程正在执行别的任务");
    }
}


class TaskCallable implements Callable<Object>{

    @Override
    public Object call() throws Exception {
        System.out.println("子线程正在执行任务...");
        Thread.sleep(5000);
        System.out.println("子线程执行结束任务...");
        return "liuqiang";
    }
}

