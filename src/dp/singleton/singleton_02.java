package dp.singleton;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/26 14:54
 *
 * 懒汉式
 *  多线程不安全：会创建多个实例
 */
public class singleton_02 {
    private static singleton_02 INSTANCE;
    private singleton_02() {}

    public static singleton_02 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new singleton_02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(singleton_02.getInstance().hashCode());
            }).start();
        }
    }
}
