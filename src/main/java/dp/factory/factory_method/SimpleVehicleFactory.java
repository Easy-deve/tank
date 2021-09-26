package dp.factory.factory_method;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/30 17:11
 *
 * 简单工厂，可扩展性不好
 */
public class SimpleVehicleFactory {

    public Car createCar() {
        // before processing
        return new Car();
    }

    public Plane createPlane() {
        // before processing
        return new Plane();
    }

    public Broom createBroom() {
        // before processing
        return new Broom();
    }
}
