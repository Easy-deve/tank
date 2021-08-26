package dp.singleton;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/26 15:28
 *
 * 完美式
 *  用静态内部类实现
 *      JVM保证单例
 *      加载外部类时不会加载内部类，这样可以实现懒加载
 *
 */
public class singleton_06 {

    private singleton_06() {}

    public static class s_06_holder {
        private static singleton_06 INSTANCE = new singleton_06();
    }

    public static singleton_06 getInstance() {
        return s_06_holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(singleton_06.getInstance().hashCode());
            }).start();
        }
    }
}
