package com.easy.tank;

import com.easy.cor.ChainCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/5 9:11
 */
public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    public Tank myTank;
//    public List<Tank> tankList = new ArrayList<>();
//    public List<Bullet> bulletList = new ArrayList<>();
//    //    public Explode explode = new Explode(100, 100, this);
//    public List<Explode> explodeList = new ArrayList<>();
    public List<GameObject> objectList = new ArrayList<>();
//    BulletTankCollider btCollider = new BulletTankCollider();
//    TankTankCollider ttCollider = new TankTankCollider();
    ChainCollider chainCollider = new ChainCollider();

    static {
        INSTANCE.init();
    }

    private void init() {
        // 添加自己的坦克到碰撞队列中
        myTank = new Tank(200, 400, Dir.UP, Group.GOOD);
        int initTankCounts = Integer.parseInt((String) PropertyMgr.get("initTankCounts"));
        // 初始化敌方坦克
        for (int i = 0; i < initTankCounts; i++) {
            new Tank(150 + i*100,50, Dir.DOWN, Group.BAD);
        }
        // 初始化墙
        new Wall(150, 150, 200, 50);
        new Wall(550, 150, 200, 50);
        new Wall(300, 300, 50, 200);
        new Wall(550, 300, 50, 200);
    }

    private GameModel() { }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void add(GameObject gameObject) {
        objectList.add(gameObject);
    }

    public void remove(GameObject gameObject) {
        objectList.remove(gameObject);
    }

    public void paint(Graphics g) {
        //这里保证自己的坦克会一直重新绘画，永远不死
//        myTank.paint(g);

        for (int i = 0; i < objectList.size(); i++) {
            objectList.get(i).paint(g);
        }
        // 会报java.util.ConcurrentModificationException异常
        // for (Bullet bullet : bulletList) {
        //     bullet.paint(g);
        // }

//        for (int i = 0; i <bulletList.size() ; i++) {
//            bulletList.get(i).paint(g);
//        }
//        for (int i = 0; i < tankList.size(); i++) {
//            tankList.get(i).paint(g);
//        }
//        for (int i = 0; i < explodeList.size(); i++) {
//            explodeList.get(i).paint(g);
//        }

        for (int i = 0; i < objectList.size(); i++) {
            for (int j = i+1; j < objectList.size(); j++) {
                GameObject o1 = objectList.get(i);
                GameObject o2 = objectList.get(j);
//                btCollider.collide(o1, o2);
//                ttCollider.collide(o1, o2);
                chainCollider.collide(o1, o2);
            }
        }
//        for (int i = 0; i < bulletList.size(); i++) {
//            for (int j = 0; j < tankList.size(); j++) {
//                bulletList.get(i).collideWith(tankList.get(j));
//            }
//        }
    }
}