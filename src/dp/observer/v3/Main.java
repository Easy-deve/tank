package dp.observer.v3;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/19 7:48
 *
 * 加入一个观察者到被观察者中
 */
public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        int count = 0;
        while (!child.isCry()) {
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Observing...");
            if (count == 5) {
                child.setCry();
            }
        }
        child.wakeUp();
    }
}

class Child {
    private boolean cry;
    // 如果有多个事件，要写多个观察者，耦合度过高，也不灵活
    private Dad dad = new Dad();

    public boolean isCry() {
        return cry;
    }
    public void setCry() {
        cry = true;
    }

    public void wakeUp() {
        System.out.println("Child wake up! Crying williwaw!");
        cry = true;
        dad.feed();
    }
}

class Dad {
    public void feed() {
        System.out.println("Dad feeding...");
    }
}
