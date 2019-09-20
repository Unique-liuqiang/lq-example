package JVM;

/**
 * 设置新生代与老年代比例参数
 */
public class Test003 {
    /**
     * 使用示例: -Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC -XX:NewRatio=2
     * 说明：堆内存初始化值20m,堆内存最大值20m，新生代最大值可用1m，eden空间和from/to空间的比例为2/1
     * 新生代和老年代的占比为1/2
     * @param args
     */
    public static void main(String[] args){
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1 * 1024 * 1024];
        }
    }
}
