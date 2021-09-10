package com.easy.cor;

import com.easy.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/10 10:13
 */
public class ChainCollider implements Collider {
    public List<Collider> colliders = new LinkedList<>();

    public ChainCollider() {
        colliders.add(new BulletTankCollider());
        colliders.add(new TankTankCollider());
    }

    public void addCollider(Collider collider) {
        colliders.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (Collider collider : colliders) {
            if (collider.collide(o1, o2)) {
                return true;
            }
        }
        return false;
    }
}
