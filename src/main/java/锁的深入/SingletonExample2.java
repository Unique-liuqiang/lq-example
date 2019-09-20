package 锁的深入;

/**
 * 枚举单例模式最安全
 */
public class SingletonExample2 {

    private SingletonExample2() {
    }

    public static SingletonExample2 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        /**
         *实列化
         */
        INSTANCE();
        private SingletonExample2 singleton;

        /* JVM保证这个方法绝对只调用一次 */
        Singleton() {
            singleton = new SingletonExample2();
        }

        public SingletonExample2 getInstance() {
            return singleton;
        }
    }
}

