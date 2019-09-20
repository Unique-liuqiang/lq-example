package 多线程安全;

class ThreadDemo  implements Runnable{

    private int count = 100;

    @Override
    public void run() {
        while (count>0){
            sale();
        }
    }

    /**
     * synchronized解决买同一张票等问题
     * if 判断解决最后一张票买出问题
     * t1 t2
     */
    private  synchronized   void sale(){
        if(count>0) {
            System.out.println(Thread.currentThread().getName() + ",出售第" + (100 - count + 1) + "张票");
            count--;
        }
    }
}

public class Test001 {
    public static void main(String[] args) {
        ThreadDemo threadDemo=new ThreadDemo();
        Thread thread1=new Thread(threadDemo,"窗口一");
        Thread thread2=new Thread(threadDemo,"窗口二");
        thread1.start();
        thread2.start();
    }
}
