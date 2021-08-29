package dp.strategy;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/29 8:56
 */
public class Dog implements Comparable {
    private int food;

    public Dog(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }


    @Override
    public int compareTo(Object o) {
        Dog d = (Dog) o;
        if (this.food < d.food) return -1;
        else if (this.food > d.food) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
