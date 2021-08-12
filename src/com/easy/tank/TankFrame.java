package com.easy.tank;

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
    private int x = 200, y = 200;
    private Dir dir = Dir.STOP;
    private static final int SPEED = 10;

    public TankFrame() {
        setVisible(true);
        setSize(800, 600);
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

    @Override
    public void paint(Graphics g) {
        System.out.println("x: " + x + ",y: " + y);
        g.fillRect(x, y, 50, 50);
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
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
            if (leftKey) dir = Dir.LEFT;
            if (upKey) dir = Dir.UP;
            if (rightKey) dir = Dir.RIGHT;
            if (downKey) dir = Dir.DOWN;
        }
    }
}
