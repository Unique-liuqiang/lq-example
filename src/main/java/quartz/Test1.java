package quartz;

public class Test1 implements Runnable {
    @Override
    public void run() {
        System.out.println("run");
    }
    public static void main(String[] args){
        Test1 test1=new Test1();
        //test1.run();
        Thread thread=new Thread(test1);
        thread.start();
    }
}
