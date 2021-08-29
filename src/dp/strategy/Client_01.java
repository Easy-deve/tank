package dp.strategy;

import dp.singleton.singleton_01;

import java.util.Arrays;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/27 16:26
 *
 * 问题1：对整型数组排序
 * 问题2：对浮点型数组排序
 * 问题3：对猫类数组排序（只针对猫的身高）
 * 问题4：对狗类数组排序（只针对狗的饭量）
 * 问题5：对猫类数组排序（针对猫的体重）-> 引出策略模式
 *
 */
public class Client_01 {

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 7, 9 ,3};
        Cat[] cats = { new Cat(1,1),new Cat(6,6),
                new Cat(2,2),new Cat(7,7),
                new Cat(9,9),new Cat(3,3) };
        Dog[] dogs = { new Dog(1),new Dog(6), new Dog(2),
                new Dog(7), new Dog(9),new Dog(3) };
        Sort.sort(cats);
        System.out.println(Arrays.toString(cats));
        Sort.sort(dogs);
        System.out.println(Arrays.toString(dogs));
    }
}
