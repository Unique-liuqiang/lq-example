package 多线程安全.wait与notify;


class Res {

    public String name;

    public String sex;

    /**
     *  false只能写,true只能读
     */
    public boolean flag = false;
}

/**
 * 生产者线程
 */
class IntThread extends Thread {

    public Res res;

    public IntThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;

        while (true) {
            synchronized (res) {
              /*  if(res.flag){
                    try {
                        res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                if (count == 0) {
                    res.name = "小红";
                    res.sex = "女";
                } else {
                    res.name = "小明";
                    res.sex = "男";
                }
                count = (count + 1) % 2;
              /*  res.flag=true;
                res.notify();//唤醒等待的读线程*/
            }
        }

    }
}

/**
 * 消费者线程
 */
class OutThread extends Thread {
    public Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res){
               /* if(!res.flag){
                        try {
                            res.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(res.name + "," + res.sex);
             /*   res.flag=false;
                res.notify();//唤醒写线程*/
            }
        }
    }
}

/**
 * 演示线程之间的通讯wait与notify实现写一个读一个的功能
 */
public class Test001 {
    public static void main(String[] args) {
        Res res = new Res();
        IntThread intThread = new IntThread(res);
        OutThread outThread = new OutThread(res);
        intThread.start();
        outThread.start();
    }
}
