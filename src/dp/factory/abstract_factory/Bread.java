package dp.factory.abstract_factory;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/2 10:20
 */
public class Bread implements Food {
    @Override
    public void getName() {
        System.out.println("Modern food: bread");
    }
}
