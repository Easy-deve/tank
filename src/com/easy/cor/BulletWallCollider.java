package com.easy.cor;

import com.easy.tank.*;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/9 21:45
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
            return collideWith(b, w);
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            return collide(o2, o1);
        } else {
            return false;
        }
    }

    private boolean collideWith(Bullet bullet, Wall wall) {
        if (bullet.rectangle.intersects(wall.getRectangleWall())) {
            bullet.die();
            return true;
        }
        return false;
    }
}
