package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 9:50
 */
public abstract class BaseFactory {

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();

    abstract Food createFood();

}
