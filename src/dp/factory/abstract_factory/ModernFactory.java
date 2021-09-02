package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 10:17
 */
public class ModernFactory implements BaseFactory {

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Food createFood() {
        return new Bread();
    }

}
