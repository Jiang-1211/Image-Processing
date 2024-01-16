
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class TestMain {

    public static void main(String[] args) {
        try {
            File input=new File("./Image/pika.png");
            BufferedImage ima=ImageIO.read(input);
//            BufferedImage ima=ImageIO.read(new URL("blob:https://colab.research.google.com/47d06e2e-cbd7-4cbc-8bea-df88f4c9770c"));
            BufferedImage res=new BufferedImage(ima.getWidth(), ima.getHeight(), BufferedImage.TYPE_INT_RGB);
            res.createGraphics().drawImage(ima,0,0, Color.WHITE, null);
            File output=new File("./Image/pika_jpg.jpg");
            ImageIO.write(res, "jpg", output);
        } catch (Exception e) {
        }
    }
}
