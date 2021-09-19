package dp.observer.v5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/19 10:49
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
        String context = "Child wake up! Crying williwaw!";
        cry = true;
        System.out.println(context);
        Event e = new WakeUpEvent(new Date(), "bed", context, this);
        for (Observer observer : observers) {
            observer.actionOnWakeUp(e);
        }
    }
}

abstract class Event<T> {
    private String name;
    abstract T getSource();
}

class WakeUpEvent extends Event<Child> {
    private Date time;
    private String local;
    private String context;
    // 一般事件中会有被观察者的引用
    private Child source;

    public WakeUpEvent(Date time, String local, String context, Child child) {
        this.time = time;
        this.local = local;
        this.context = context;
        this.source = child;
    }

    public WakeUpEvent(Date time, String local) {
        this.time = time;
        this.local = local;
    }

    public String getInfo() {
        return "Cry time: " + time + ", cry local: " + local + ", cry context: " + context;
    }

    @Override
    protected Child getSource() {
        return source;
    }
}

interface Observer {
    void actionOnWakeUp(Event e);
}

class Dad implements Observer {
    public void feed() {
        System.out.println("Dad feeding...");
    }
    @Override
    public void actionOnWakeUp(Event e) {
        WakeUpEvent event = (WakeUpEvent) e;
        System.out.println(event.getInfo());
        feed();
    }
}

class Mom implements Observer {
    public void hug() {
        System.out.println("Mom hugging...");
    }
    @Override
    public void actionOnWakeUp(Event e) {
        WakeUpEvent event = (WakeUpEvent) e;
        System.out.println(event.getInfo());
        hug();
    }
}

class Dog implements Observer {
    public void call() {
        System.out.println("Dog Hwang...");
    }
    @Override
    public void actionOnWakeUp(Event e) {
        WakeUpEvent event = (WakeUpEvent) e;
        System.out.println(event.getInfo());
        call();
    }
}
