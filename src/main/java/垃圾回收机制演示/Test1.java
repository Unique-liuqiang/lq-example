package 垃圾回收机制演示;

/**
 * 演示回收垃圾机制
 */
public class Test1 {
    public static void main(String[] args){
        Test1 test = new Test1();
        test = null;
        System.gc(); // 手动回收垃圾
    }
    @Override
    protected void finalize() throws Throwable {
        // gc回收垃圾之前调用
        System.out.println("垃圾回收机制...");
    }
}
