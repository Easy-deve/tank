package dp.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/19 21:36
 */
public class BulletPool {
    List<Bullet> bulletList = new ArrayList<>();
    {
        for (int i = 0; i < 10; i++) bulletList.add(new Bullet());
    }

    public Bullet getBullet() {
        for (Bullet bullet : bulletList) {
            if (!bullet.live) return bullet;
        }
        return new Bullet();
    }

    public static void main(String[] args) {
        BulletPool bp = new BulletPool();
        for (int i = 0; i < 5; i++) {
            Bullet b = bp.getBullet();
            System.out.println(b);
        }
    }

}

class Bullet {
    private UUID id = UUID.randomUUID();
    boolean live = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}


