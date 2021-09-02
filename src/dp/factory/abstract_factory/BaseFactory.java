package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 9:50
 */
public interface BaseFactory {

    Vehicle createVehicle();

    Weapon createWeapon();

    Food createFood();

}
