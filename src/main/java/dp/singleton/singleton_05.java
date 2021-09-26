package dp.singleton;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/26 15:16
 *
 * 懒汉式
 *  多线程安全-局部加锁-双重if检测
 *  优点：保证多线程下只会创建一个对象，效率也会有所提高
 */
public class singleton_05 {
    private static singleton_05 INSTANCE;
    private singleton_05() {}

    public static singleton_05 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 多个线程都到达这里，会排队创建多个对象
            synchronized (singleton_05.class) {
                // 只会有一个线程进入实例化唯一一个对象
                if (INSTANCE == null) {
                    INSTANCE = new singleton_05();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(singleton_05.getInstance().hashCode());
            }).start();
        }
    }
}
