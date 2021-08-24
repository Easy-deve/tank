package com.easy.tank;

import java.awt.*;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/13 21:02
 */
public class Bullet {
    public static final int SPEED = 10;
    private int x, y;
    public static final int WIDTH = ResourceMgr.goodBulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.goodBulletD.getHeight();
    private Dir bulletDir;
    private boolean living = true;
    private TankFrame tankFrame = null;
    private Group group = Group.BAD;
    public Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.bulletDir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        this.rectangle.width = WIDTH;
        this.rectangle.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if (!living) {
            tankFrame.bulletList.remove(this);
        }
//        Color color = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x, y, WIDTH, HEIGHT);
//        g.setColor(color);

        switch (bulletDir) {
            case LEFT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badBulletL :
                        ResourceMgr.goodBulletL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badBulletU :
                        ResourceMgr.goodBulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badBulletR :
                        ResourceMgr.goodBulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badBulletD :
                        ResourceMgr.goodBulletD, x, y, null);
                break;
            default: break;
        }

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
        if (x < 0 || y < 0 || x > TankFrame.IMAGE_WIDTH || y > TankFrame.IMAGE_HEIGHT) living = false;
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    public void collideWith(Tank tank) {
        if (tank.getGroup() == this.group) return;
//        Rectangle rectBullet = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//        Rectangle rectTank = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (rectangle.intersects(tank.rectangle)) {
            this.die();
            tank.die();
            int eX = tank.getX() + WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + HEIGHT / 2 - Explode.HEIGHT / 2;
            tankFrame.explodeList.add(new Explode(eX, eY, tankFrame));
        }
    }

    private void die() {
        this.living = false;
    }
}
