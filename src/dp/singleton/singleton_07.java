package dp.singleton;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/26 15:43
 */
public enum singleton_07 {
    INSTANCE;

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(singleton_07.INSTANCE.hashCode());
            }).start();
        }
    }
}
