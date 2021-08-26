package dp.singleton;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/26 15:01
 *
 * 懒汉式
 *  多线程安全-全局加锁加锁
 *  优点：全局加锁可以保证多线程也只会创建一个实例
 *  缺点：当对象已经实例化后，每次访问还要加锁排队等待。影响效率。
 */
public class singleton_03 {
    private static singleton_03 INSTANCE;
    private singleton_03() {}

    public static synchronized singleton_03 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new singleton_03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(singleton_03.getInstance().hashCode());
            }).start();
        }
    }
}
