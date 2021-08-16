package com.easy.tank;

import java.awt.*;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/12 11:47
 */
public class Tank {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 10;
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    private boolean moving = false;
    private TankFrame tankFrame;

    public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        System.out.println("x: " + x + ",y: " + y);
        g.fillRect(x, y, WIDTH, HEIGHT);
        move();
    }

    private void move() {
        if (!moving) return;

        switch (dir) {
            case LEFT:
                x -= SPEED; break;
            case UP:
                y -= SPEED; break;
            case RIGHT:
                x += SPEED; break;
            case DOWN:
                y += SPEED; break;
            default: break;
        }
    }

    public void fire() {
        tankFrame.bulletList.add(new Bullet(this.x, this.y, this.dir, tankFrame));
    }
}
