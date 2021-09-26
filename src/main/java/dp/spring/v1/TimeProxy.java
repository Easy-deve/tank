package dp.spring.v1;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/26 15:32
 */
public class TimeProxy {
    void before() {
        System.out.println("before time: " + System.currentTimeMillis());
    }
    void after() {
        System.out.println("after time: " + System.currentTimeMillis());
    }
}
