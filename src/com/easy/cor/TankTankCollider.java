package com.easy.cor;

import com.easy.tank.Bullet;
import com.easy.tank.GameObject;
import com.easy.tank.Tank;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/9 21:45
 */
public class TankTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.rectangle.intersects(t2.rectangle)) {
                t1.stop();
                t2.stop();
            }
        } else {
            return;
        }
    }
}
