package com.easy.tank;

import java.awt.*;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/21 16:27
 */
public class Explode extends GameObject {
    private int x,y;
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
//    private GameModel gameModel;
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
//        new Audio("audio/explode.wav").run();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            GameModel.getInstance().remove(this);
    }
}
