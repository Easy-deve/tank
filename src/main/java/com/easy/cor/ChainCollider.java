package com.easy.cor;

import com.easy.tank.GameObject;
import com.easy.tank.PropertyMgr;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/10 10:13
 */
public class ChainCollider implements Collider {
    public List<Collider> colliders = new LinkedList<>();

    public ChainCollider() {
        String[] colliderValues = String.valueOf(PropertyMgr.get("colliders")).split(",");
        for (String value : colliderValues) {
            try {
                colliders.add((Collider) Class.forName(value).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
//        colliders.add(new BulletTankCollider());
//        colliders.add(new TankTankCollider());
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
