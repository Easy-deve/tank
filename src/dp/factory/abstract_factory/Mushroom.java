package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 14:03
 */
public class Mushroom implements Food {
    @Override
    public void getName() {
        System.out.println("Magic food: mushroom");
    }
}
