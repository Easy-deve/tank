package dp.strategy;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/27 17:21
 */
public class Cat implements Comparable {

    private int weight;
    private int height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public Cat(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Cat c = (Cat) o;
        if (this.height < c.height) return -1;
        else if (this.height > c.height) return 1;
        else return 0;
    }
}
