package dp.strategy;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/29 9:42
 */
public class CatWeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        if (t1.getWeight() < t2.getWeight()) return -1;
        else if (t1.getWeight() > t2.getWeight()) return 1;
        else return 0;
    }
}
