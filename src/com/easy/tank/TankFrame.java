package com.easy.tank;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/9 23:38
 */
public class TankFrame extends Frame {

    static final int IMAGE_HEIGHT = 600;
    static final int IMAGE_WIDTH = 800;
    Tank myTank = new Tank(200, 200, Dir.DOWN);
    Bullet bullet = new Bullet(200, 200, Dir.DOWN);

    public TankFrame() {
        setVisible(true);
        setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
        setResizable(false);
        setTitle("tank war");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new MyKeyListener());
    }

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(IMAGE_WIDTH, IMAGE_HEIGHT);
        }
        Graphics imageGraphics = offScreenImage.getGraphics();
        Color color = imageGraphics.getColor();
        imageGraphics.setColor(Color.BLUE);
        imageGraphics.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);
        imageGraphics.setColor(color);
        paint(imageGraphics);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        bullet.paint(g);
    }

    class MyKeyListener extends KeyAdapter {
        private boolean leftKey = false;
        private boolean rightKey = false;
        private boolean upKey = false;
        private boolean downKey = false;

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    leftKey = true;
                    break;
                case KeyEvent.VK_UP:
                    upKey = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightKey = true;
                    break;
                case KeyEvent.VK_DOWN:
                    downKey = true;
                    break;
                default:
                    break;
            }
            getMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    leftKey = false;
                    break;
                case KeyEvent.VK_UP:
                    upKey = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    rightKey = false;
                    break;
                case KeyEvent.VK_DOWN:
                    downKey = false;
                    break;
                default:
                    break;
            }
            getMainTankDir();
        }

        private void getMainTankDir() {
            if (leftKey || upKey || rightKey || downKey) {
                myTank.setMoving(true);
                if (leftKey) myTank.setDir(Dir.LEFT);
                if (upKey) myTank.setDir(Dir.UP);
                if (rightKey) myTank.setDir(Dir.RIGHT);
                if (downKey) myTank.setDir(Dir.DOWN);
            } else {
                myTank.setMoving(false);
            }
        }
    }
}
