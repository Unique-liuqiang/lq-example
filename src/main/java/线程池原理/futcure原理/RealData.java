package 线程池原理.futcure原理;

public class RealData implements Data
{
     private String result;


    public RealData(String data) {
        System.out.println("正在使用data:" + data + "网络请求数据,耗时操作需要等待.");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
        System.out.println("操作完毕,获取结果...");
        result = "liudaqiang";
    }

    @Override
    public String getRequest() {
        return result;
    }
}
