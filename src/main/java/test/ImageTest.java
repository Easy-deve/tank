package test;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: yangzhiyao
 * @DateTime: 2021/8/16 23:49
 */
public class ImageTest {
    @Test
    public void test() {
        try {
//            BufferedImage bufferedImage = ImageIO.read(new File("D:/test/image/hhh.jpg"));
//            Assert.assertNotNull(bufferedImage);
            BufferedImage buff = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/hhh.jpg"));
            Assert.assertNotNull(buff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
