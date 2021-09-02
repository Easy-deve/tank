package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 10:17
 */
public class MagicFactory implements BaseFactory {

    @Override
    public Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    public Food createFood() {
        return new Mushroom();
    }

}
