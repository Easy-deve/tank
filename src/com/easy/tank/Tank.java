package com.easy.tank;

import java.awt.*;
import java.util.Random;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/12 11:47
 */
public class Tank {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceMgr.goodTankD.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankD.getHeight();
    private boolean moving = true;
//    private TankFrame tankFrame;
    private GameModel gameModel;
    private boolean living = true;
    private Random random = new Random();
    private Group group = Group.BAD;
    public Rectangle rectangle = new Rectangle();
    private FireStrategy fireStrategy;

    public Tank(int x, int y, Dir dir, Group group, GameModel gameModel) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gameModel = gameModel;
        this.rectangle.x = this.x;
        this.rectangle.y = this.y;
        this.rectangle.width = WIDTH;
        this.rectangle.height = HEIGHT;
        if (this.group == Group.GOOD) {
            try {
                fireStrategy = (FireStrategy) Class.forName(String.valueOf(PropertyMgr.get("fireStrategy"))).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            fireStrategy = new DefaultFireStrategy();
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void paint(Graphics g) {
        if (!living) {
            // 直接用return会出现坦克看似消失实际没消失的问题，
            // 因为最开始坦克已经生成，return并没有把对应的坦克应用remove掉，
            // 容易发生内存泄漏。
            // return;
            gameModel.tankList.remove(this);
        }
        System.out.println("x: " + x + ",y: " + y);
//        g.fillRect(x, y, WIDTH, HEIGHT);
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankL :
                        ResourceMgr.goodTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankU :
                        ResourceMgr.goodTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankR :
                        ResourceMgr.goodTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.BAD ? ResourceMgr.badTankD :
                        ResourceMgr.goodTankD, x, y, null);
                break;
            default: break;
        }
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
        if (this.group == Group.BAD) {
            randomFire();
            randomDir();
        }
        boundsCheck();
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 0) x = 0;
        if (this.y < 30) y = 30; // tank bar is 30 height on screen top
        if (this.x > TankFrame.IMAGE_WIDTH - Tank.WIDTH) x = TankFrame.IMAGE_WIDTH - Tank.WIDTH;
        if (this.y > TankFrame.IMAGE_HEIGHT - Tank.HEIGHT) y = TankFrame.IMAGE_HEIGHT - Tank.HEIGHT;
    }

    private void randomFire() {
        if (random.nextInt(100) > 95)
            this.fire();
    }

    private void randomDir() {
        if (random.nextInt(100) > 95)
            this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
//        System.out.println("tank width: " + WIDTH + ", " + "tank height: " + HEIGHT);
//        System.out.println("tank bullet: " + Bullet.WIDTH + ", " + "tank bullet: " + Bullet.HEIGHT);
//        int bX = this.x + WIDTH / 2 - Bullet.WIDTH / 2;
//        int bY = this.y + HEIGHT / 2 - Bullet.HEIGHT / 2;
//        tankFrame.bulletList.add(new Bullet(bX, bY, this.dir, group, tankFrame));
        fireStrategy.fire(this);
    }

    public void die() {
        this.living = false;
    }
}
