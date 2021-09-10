package com.easy.cor;

import com.easy.tank.GameObject;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/9 21:42
 */
public interface Collider {
    void collide(GameObject o1, GameObject o2);
}
