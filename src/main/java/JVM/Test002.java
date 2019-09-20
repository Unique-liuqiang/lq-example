package JVM;

/**
 * 设置新生代比例参数
 */
public class Test002 {
    /**
     * 使用示例:-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
     * 说明：堆内存初始化值20m,堆内存最大值20m，新生代最大值可用1m，eden空间和from/to空间的比例为2/1
     * @param args
     */
    public static void main(String[] args){
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[10 * 1024 * 1024];
        }
    }
}
