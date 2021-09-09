package com.easy.strategy;

import com.easy.tank.Bullet;
import com.easy.tank.Dir;
import com.easy.tank.Tank;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/29 23:41
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            new Bullet(bX, bY, dir, t.getGroup(), t.getGameModel());
        }

    }
}
