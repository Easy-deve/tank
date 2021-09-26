package dp.proxy.v1;

import dp.proxy.Movable;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/26 9:27
 *
 * 静态代理：（类似装饰模式）
 *      1. 代理类和实际类都实现了相同的接口
 *      2. 代理类内部必须要有共同接口的引用：Movable
 *      3. 通过构造参数将被代理类初始化引入进来
 * 优点：
 * 缺点：无法代理不同类型的对象，比如Bullet
 */
public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("tank move, kakaka...");
    }

    public static void main(String[] args) {
        Movable tankProxy = new TankLogProxy(new TankTimeProxy(new Tank()));
        tankProxy.move();
    }
}

class TankTimeProxy implements Movable {
    Movable tank;

    public TankTimeProxy(Movable tank) {
        this.tank = tank;
    }

    private void before() {
        System.out.println(System.currentTimeMillis());
    }
    private void after() {
        System.out.println(System.currentTimeMillis());
    }
    @Override
    public void move() {
        before();
        tank.move();
        after();
    }
}

class TankLogProxy implements Movable {
    Movable tank;

    public TankLogProxy(Movable tank) {
        this.tank = tank;
    }

    private void before() {
        System.out.println("start moving----------------");
    }

    private void after() {
        System.out.println("end moving----------------");
    }

    @Override
    public void move() {
        before();
        tank.move();
        after();
    }
}
