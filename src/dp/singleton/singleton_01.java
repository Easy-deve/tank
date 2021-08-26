package dp.singleton;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/26 14:43
 *
 * 饿汉式
 *  类加载到内存后，就实例化一个单例，JVM保证线程安全
 *  简单实用，推荐使用！
 *  唯一缺点：不管用到与否，类装载时就完成实例化
 *
 */
public class singleton_01 {
    private static final singleton_01 INSTANCE = new singleton_01();

    private singleton_01() { }

    public static singleton_01 getInstance() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(singleton_01.getInstance().hashCode());
            }).start();
        }
    }
}
