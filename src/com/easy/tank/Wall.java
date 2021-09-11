package com.easy.tank;

import java.awt.*;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/9/11 8:34
 */
public class Wall extends GameObject {
    private int width;
    private int height;
    private Rectangle rectangleWall;

    public Wall(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        rectangleWall = new Rectangle(x, y, width, height);
    }
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.darkGray);
        g.fillRect(x, y, width, height);
        g.setColor(color);
    }
}
