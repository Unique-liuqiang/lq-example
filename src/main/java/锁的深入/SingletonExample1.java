package 锁的深入;

/**
 * @author 86138
 * 懒汉模式 -》 双重同步锁单例模式
 */
public class SingletonExample1 {

    // 单例对象 volatile + 双重检测机制 -> 禁止指令重排
    private static  SingletonExample1 instance;


    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存
    private SingletonExample1(){

    }

    public static SingletonExample1 getInstance(){
        //B
        if (instance == null) {
            synchronized (SingletonExample1.class) {
                if(instance==null){
                    //A
                    instance = new SingletonExample1();
                }
            }
        }
        return instance;
    }
}
