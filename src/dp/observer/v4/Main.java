package dp.observer.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/19 8:03
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
            if (count == 3) {
                child.setCry();
            }
        }
        child.wakeUp();
    }
}

class Child {
    private boolean cry;
    // 将多个观察者封装到一起，便于管理维护
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }
    public void setCry() {
        cry = true;
    }

    public void wakeUp() {
        System.out.println("Child wake up! Crying williwaw!");
        cry = true;
        for (Observer observer : observers) {
            observer.actionOnWakeUp();
        }
    }
}

interface Observer {
    void actionOnWakeUp();
}

class Dad implements Observer {
    public void feed() {
        System.out.println("Dad feeding...");
    }
    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mom implements Observer {
    public void hug() {
        System.out.println("Mom hugging...");
    }
    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements Observer {
    public void call() {
        System.out.println("Dog Hwang...");
    }
    @Override
    public void actionOnWakeUp() {
        call();
    }
}
