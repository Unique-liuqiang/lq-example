package 锁的深入;


import java.util.concurrent.atomic.AtomicInteger;

/**
 *演示原子类(不加锁)的作用不保证输出顺序(使用到了CAS无锁技术)
 */
public class AtomicIntegerTest implements Runnable{

    private volatile int count=0;

    private static AtomicInteger atomic = new AtomicInteger();

    @Override
    public void run() {
       while (true){
           int count1 = getCount();
           if(count1>150){
               break;
           }
           System.out.println("count1的值为"+count1);
       }
    }
   public   int getCount(){
       try {
           Thread.sleep(100);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return  count++;
   }

   public int getCount1(){
       try {
           Thread.sleep(100);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       return  atomic.incrementAndGet();
   }
   
   public static void main(String[] args){
       AtomicIntegerTest test=new AtomicIntegerTest();
       Thread t1=new Thread(test);
       Thread t2=new Thread(test);
       t1.start();
       t2.start();
   }
}
