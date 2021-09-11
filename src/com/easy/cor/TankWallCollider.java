package com.easy.cor;

import com.easy.tank.GameObject;
import com.easy.tank.Tank;
import com.easy.tank.Wall;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/9 21:45
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if (tank.rectangle.intersects(wall.getRectangleWall())) {
                tank.backOff();
            }
        }
        return false;
    }
}
