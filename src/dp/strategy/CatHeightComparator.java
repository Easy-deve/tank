package dp.strategy;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/29 9:42
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat t1, Cat t2) {
        if (t1.getHeight() > t2.getHeight()) return -1;
        else if (t1.getHeight() < t2.getHeight()) return 1;
        else return 0;
    }
}
