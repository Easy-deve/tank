package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 10:18
 */
public class Car implements Vehicle {
    @Override
    public void getName() {
        System.out.println("Modern vehicle: car");
    }
}
