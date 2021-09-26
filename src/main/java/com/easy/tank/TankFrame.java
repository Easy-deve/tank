package com.easy.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/9 23:38
 */
public class TankFrame extends Frame {

    static final int IMAGE_HEIGHT = 960;
    static final int IMAGE_WIDTH = 1080;

//    public GameModel gameModel = new GameModel();

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
        drawString(g);
        GameModel.getInstance().paint(g);
    }

    private void drawString(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量" + gameModel.bulletList.size(), 10, 60);
//        g.drawString("敌人的数量" + gameModel.tankList.size(), 10, 80);
//        g.drawString("爆炸的数量" + gameModel.explodeList.size(), 10, 100);
        g.setColor(color);
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
                case KeyEvent.VK_CONTROL:
                    GameModel.getInstance().myTank.fire();
                    break;
                default:
                    break;
            }
            getMainTankDir();
        }

        private void getMainTankDir() {
            Tank myTank = GameModel.getInstance().myTank;
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