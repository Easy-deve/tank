package dp.strategy;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/27 16:35
 */
public class StrategySort<T> {
    public void sort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (comparator.compare(arr[i], arr[j]) > 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
