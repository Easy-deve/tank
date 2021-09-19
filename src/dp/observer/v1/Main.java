package dp.observer.v1;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/19 7:24
 */
public class Main {
    public static void main(String[] args) {
        boolean cry = false;

        // 只要没哭就一直观察
        while (!cry) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Observing...");
        }
        // 哭了就要做相应处理
        System.out.println("child crying!");
        System.out.println("Mom feeding!");
    }
}
