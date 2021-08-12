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

        while(true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
