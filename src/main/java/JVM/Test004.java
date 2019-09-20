package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 *堆栈溢出
 */
public class Test004 {
    public static void main(String[] args){
        /**
         * // -Xms1m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
         */
        List<Object> listObject = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.println("i:" + i);
            Byte[] bytes = new Byte[1 * 1024 * 1024];
            listObject.add(bytes);
        }
        System.out.println("添加成功...");

    }
}
