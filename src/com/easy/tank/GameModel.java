package com.easy.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/5 9:11
 */
public class GameModel {

    public Tank myTank = new Tank(200, 400, Dir.UP, Group.GOOD, this);
//    public List<Tank> tankList = new ArrayList<>();
//    public List<Bullet> bulletList = new ArrayList<>();
//    //    public Explode explode = new Explode(100, 100, this);
//    public List<Explode> explodeList = new ArrayList<>();
    public List<GameObject> objectList = new ArrayList<>();

    public GameModel() {
        int initTankCounts = Integer.parseInt((String) PropertyMgr.get("initTankCounts"));
        // 初始化敌方坦克
        for (int i = 0; i < initTankCounts; i++) {
            add(new Tank(150 + i*100,50, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject gameObject) {
        objectList.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        objectList.remove(gameObject);
    }

    public void paint(Graphics g) {
        myTank.paint(g);

        for (int i = 0; i < objectList.size(); i++) {
            objectList.get(i).paint(g);
        }
//        for (int i = 0; i <bulletList.size() ; i++) {
//            bulletList.get(i).paint(g);
//        }
//        for (int i = 0; i < tankList.size(); i++) {
//            tankList.get(i).paint(g);
//        }
//        for (int i = 0; i < explodeList.size(); i++) {
//            explodeList.get(i).paint(g);
//        }

//        for (int i = 0; i < bulletList.size(); i++) {
//            for (int j = 0; j < tankList.size(); j++) {
//                bulletList.get(i).collideWith(tankList.get(j));
//            }
//        }
        // 会报java.util.ConcurrentModificationException异常
        // for (Bullet bullet : bulletList) {
        //     bullet.paint(g);
        // }
    }
}
