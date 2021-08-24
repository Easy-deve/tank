import com.easy.tank.Dir;
import com.easy.tank.Group;
import com.easy.tank.PropertyMgr;
import com.easy.tank.Tank;
import com.easy.tank.TankFrame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/9 21:42
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        int initTankCounts = Integer.parseInt((String) PropertyMgr.get("initTankCounts"));
        // 初始化敌方坦克
        for (int i = 0; i < initTankCounts; i++) {
            tankFrame.tankList.add(new Tank(150 + i*100,50, Dir.DOWN, Group.BAD, tankFrame));
        }

        while(true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
