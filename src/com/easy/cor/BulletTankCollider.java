package com.easy.cor;

import com.easy.tank.Bullet;
import com.easy.tank.GameObject;
import com.easy.tank.Tank;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/9 21:45
 */
public class BulletTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            b.collideWith(t);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        } else {
            return;
        }
    }
}
