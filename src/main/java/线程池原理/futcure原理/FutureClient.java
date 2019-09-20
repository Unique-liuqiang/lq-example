package 线程池原理.futcure原理;

/**
 * @author 86138
 * 手写代码演示fucture模式
 */
public class FutureClient {
    public Data request(String queryStr) {
        FurureData furureData = new FurureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(queryStr);
                furureData.setRealData(realData);  //子线程经行设置数据
            }
        }).start();
        return furureData;
    }
    public static void main(String[] args){
        FutureClient futureClient = new FutureClient();
        Data request = futureClient.request("请求参数.");
        //线程切换到主进程执行功能
        System.out.println("请求发送成功!");
        System.out.println("执行其他任务...");

        //主线程获取数据会发生等待
        String result = request.getRequest();

        System.out.println("获取到结果..." + result);
    }
}
