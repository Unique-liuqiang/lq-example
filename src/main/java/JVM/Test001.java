package JVM;

/**
 *堆内存大小配置
 */
public class Test001 {
    public static void main(String[] args){
        // byte[] b = new byte[4 * 1024 * 1024];
        // System.out.println("分配了4M空间给数组");
        System.out.print("最大内存");
        System.out.println(Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M");
        System.out.print("可用内存");
        System.out.println(Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M");
        System.out.print("已经使用内存");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");

    }
}
