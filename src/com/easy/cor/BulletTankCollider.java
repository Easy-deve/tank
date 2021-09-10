package com.easy.cor;

import com.easy.tank.Bullet;
import com.easy.tank.Explode;
import com.easy.tank.GameObject;
import com.easy.tank.Tank;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/9 21:45
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            return collideWith(b, t);
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            return collide(o2, o1);
        } else {
            return false;
        }
    }

    private boolean collideWith(Bullet bullet, Tank tank) {
        if (tank.getGroup() == bullet.getGroup()) return false;
        if (bullet.rectangle.intersects(tank.rectangle)) {
            bullet.die();
            tank.die();
            int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            bullet.getGameModel().add(new Explode(eX, eY, bullet.getGameModel()));
            return true;
        }
        return false;
    }
}
