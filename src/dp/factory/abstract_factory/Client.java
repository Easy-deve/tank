package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 10:21
 */
public class Client {
    public static void main(String[] args) {
        BaseFactory factory = new MagicFactory();
        factory.createFood().getName();
        factory.createVehicle().getName();
        factory.createWeapon().getName();
    }
}
