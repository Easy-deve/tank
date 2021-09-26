package dp.strategy;

import java.util.Arrays;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/29 9:18
 *
 * 策略模式：开闭原则（对修改关闭，对扩展开放）
 */
public class Client_02 {

    public static void main(String[] args) {
        Cat[] cats = { new Cat(1,1),new Cat(6,6),
                new Cat(2,2),new Cat(7,7),
                new Cat(9,9),new Cat(3,3) };
        StrategySort<Cat> strategySort = new StrategySort();
        // 体重升序
        strategySort.sort(cats, new CatWeightComparator());
        System.out.println(Arrays.toString(cats));
        // 身高降序
        strategySort.sort(cats, new CatHeightComparator());
        System.out.println(Arrays.toString(cats));

    }
}
