package com.easy.tank;

import java.awt.*;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/13 21:02
 */
public class Bullet {
    public static final int SPEED = 5;
    private int x, y;
    private static final int HEIGHT = 30, WIDTH = 30;
    private Dir bulletDir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.bulletDir = dir;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
        move();
    }

    private void move() {
        switch (bulletDir) {
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
}
