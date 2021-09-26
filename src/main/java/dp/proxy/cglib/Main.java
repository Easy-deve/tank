package dp.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/26 14:51
 *
 * cglib实现动态代理
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new LogMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class LogMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before log");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("after log");
        return result;
    }
}

class Tank {
    void move() {
        System.out.println("tank move, kakaka...");
    }
}
