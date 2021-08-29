package dp.strategy;

import dp.singleton.singleton_01;

import java.util.Arrays;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/27 16:26
 */
public class client_01 {

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 7, 9 ,3};
        Cat[] cats = { new Cat(1,1),new Cat(6,6),
                new Cat(2,2),new Cat(7,7),
                new Cat(9,9),new Cat(3,3) };
        Sort.sort(cats);
        System.out.println(Arrays.toString(cats));
    }
}
