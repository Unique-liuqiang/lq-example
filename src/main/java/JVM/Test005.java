package JVM;

/**
 * 演示虚拟机栈溢出 可通过 -Xss1M  配置  1M对应12238 2M对应24004
 */
public class Test005 {
    private static int count;
    public static void count(){
        try {
            count++;
            count();
        } catch (Throwable e) {
            System.out.println("最大深度:"+count);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        count();
    }

}
