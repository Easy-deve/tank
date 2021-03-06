package com.easy.tank;

import java.awt.*;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/21 16:27
 */
public class Explode {
    private int x,y;
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private TankFrame tankFrame;
    private int step = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
//        new Audio("audio/explode.wav").run();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            tankFrame.explodeList.remove(this);
    }
}
