package dp.proxy.v2;

import dp.proxy.Movable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/26 10:26
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("tank move, kakaka...");
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        // 新版jdk的位置
        // System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        // 旧版jdk的位置
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new LogHandler(tank));
        m.move();
    }
}

class LogHandler implements InvocationHandler {

    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start log, method: " + method.getName());
        Object object = method.invoke(tank, args);
        System.out.println("end log, method: " + method.getName());
        return object;
    }
}
