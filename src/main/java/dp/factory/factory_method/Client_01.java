package dp.factory.factory_method;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/30 17:08
 */
public class Client_01 {

    public static void main(String[] args) {
        Movable movable = new Car();
        movable.go();
    }
}
