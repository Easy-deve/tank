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
    private int x = 200;
    private int y = 200;
    private boolean leftKey = false;
    private boolean rightKey = false;
    private boolean upKey = false;
    private boolean downKey = false;
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
//        x += 10;
//        y += 10;
    }

    class MyKeyListener extends KeyAdapter {
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
            if (leftKey) {
                x -= 10;
            }
            if (rightKey) {
                x += 10;
            }
            if (upKey) {
                y -= 10;
            }
            if (downKey) {
                y += 10;
            }
//            switch (key) {
//                case KeyEvent.VK_LEFT:
//                    x -= 10;
//                    break;
//                case KeyEvent.VK_UP:
//                    y -= 10;
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    x += 10;
//                    break;
//                case KeyEvent.VK_DOWN:
//                    y += 10;
//                    break;
//                default:
//                    break;
//            }
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
        }
    }
}
