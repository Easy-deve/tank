package dp.singleton;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/26 15:08
 *
 * 懒汉式
 *  多线程不安全-局部加锁-单个if检测
 *  优点：当对象被实例化后，再次访问就不再需要加锁排队等候
 *  缺点：还是不保证只实例化一个对象
 */
public class singleton_04 {
    private static singleton_04 INSTANCE;
    private singleton_04() {}

    public static singleton_04 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 多个线程都到达这里，会排队创建多个对象
            synchronized (singleton_04.class) {
                INSTANCE = new singleton_04();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(singleton_04.getInstance().hashCode());
            }).start();
        }
    }
}
