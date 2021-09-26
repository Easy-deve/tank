package dp.spring.v1;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/26 15:31
 */
public class Tank {

    public void move() {
        System.out.println("tank move, kakaka...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
