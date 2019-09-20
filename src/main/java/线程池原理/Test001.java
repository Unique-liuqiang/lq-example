package 线程池原理;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 演示阻塞与非阻塞式队列
 */
public class Test001 {
    /**
     ***取队列的时候,如果获取不到就会等待,存队列的时候，如果满了,也会等待.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue blockingQueue=new ArrayBlockingQueue<String>(3);
        blockingQueue.offer("3");
        blockingQueue.offer("2");
        //blockingQueue.offer("1",3, TimeUnit.SECONDS);
        //boolean offer = blockingQueue.offer("4", 3, TimeUnit.SECONDS);
        //System.out.println(offer);
        Object poll1 = blockingQueue.poll();
        System.out.println(poll1);
        Object poll2 =blockingQueue.poll();
        System.out.println(poll2);
        Object poll3 =blockingQueue.poll(3, TimeUnit.SECONDS);
        blockingQueue.offer("3");
        System.out.println(blockingQueue.size());
        Object poll4 =blockingQueue.poll(3, TimeUnit.SECONDS);
        System.out.println(poll3);
        System.out.println(poll4);

    }
}
