package 线程池原理.使用并发队列实现生产者与消费者;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *生产者线程
 */
class ProducerThread implements Runnable{


    private boolean flag =true;

    private BlockingQueue blockingQueue;

    private AtomicInteger count = new AtomicInteger();

    public ProducerThread(BlockingQueue blockingQueue){
       this.blockingQueue=blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("生产者线程已经启动...");
        try {
            while (flag){
                String data=count.incrementAndGet()+"";
                //满了的时候才会延迟三秒
                boolean offer = blockingQueue.offer(data, 3, TimeUnit.SECONDS);
                if(offer){
                    System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "成功..");
                }else {
                    System.out.println(Thread.currentThread().getName() + ",生产队列" + data + "失败..");
                }
                Thread.sleep(1000);
            }
        }catch (Exception e){

        }finally {
            System.out.println("生产者线程已经结束...");
        }
    }

    public void stop() {
        this.flag = false;
    }
}


/**
 * 消费者线程
 */
class ConsumerThread implements  Runnable{
    private BlockingQueue blockingQueue;

    public ConsumerThread(BlockingQueue blockingQueue){
        this.blockingQueue=blockingQueue;
    }
    @Override
    public void run() {
      System.out.println("消费者线程启动...");
      try {
          while (true){
              Object poll = blockingQueue.poll(3, TimeUnit.SECONDS);
              if (poll==null){
                  System.out.println("消费者超过2秒时间未获取到消息.");
                  return;
              }
              System.out.println("消费者获取到队列信息成功,data:" + poll);
          }
      }catch (Exception e){

      }finally {

      }

    }
}


/**
 * 演示使用使用并发队列(阻塞式队列)实现生产者与消费者
 * @author 86138
 */
public class Test001 {
    public static void main(String[] args){
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(3);
        //Executors ex=new Executors();
        ProducerThread producerThread = new ProducerThread(blockingQueue);
        ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
        Thread t1 = new Thread(producerThread);
        Thread t2 = new Thread(consumerThread);
        t1.start();
        t2.start();
        try {
            Thread.sleep(10*1000);
            producerThread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
