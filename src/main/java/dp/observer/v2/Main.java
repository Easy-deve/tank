package dp.observer.v2;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/19 7:35
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        while (!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Observing...");
        }
    }
}

class Child {
    private boolean cry;

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        System.out.println("Child wake up! Crying williwaw!");
        cry = true;
    }
}


