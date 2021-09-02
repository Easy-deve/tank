package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 10:21
 *
 * 抽象工厂：产生产品一族的
 * 使用抽象类和接口的区别：
 *  实体用抽象类（名词用抽象类）
 *  形象的用接口（形容词用接口）
 *
 */
public class Client {
    public static void main(String[] args) {
        BaseFactory factory = new ModernFactory();
        Food food = factory.createFood();
        food.getName();
        Vehicle vehicle = factory.createVehicle();
        vehicle.getName();
        Weapon weapon = factory.createWeapon();
        weapon.getName();
    }
}
