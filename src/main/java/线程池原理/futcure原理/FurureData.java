package 线程池原理.futcure原理;

public class FurureData implements  Data {

   public volatile static  boolean ISFLAG = false;

   private RealData realData;

    @Override
    public  synchronized  String getRequest() {
        while (!ISFLAG) {
            try {
                wait();
            } catch (Exception e) {

            }
        }
        System.out.println("线程的名字:"+Thread.currentThread().getName()+"执行getRealData");
        // 获取到数据,直接返回
        return realData.getRequest();
    }

    public  synchronized  void  setRealData(RealData realData){
        if(ISFLAG){
            return;
        }
        System.out.println("线程的名字:"+Thread.currentThread().getName()+"执行setRealData");
        this.realData = realData;
        ISFLAG = true;
        this.notify();
    }
}
