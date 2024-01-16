package source;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class inputFile {
    public static void getPixel(int[][] matrixInput, File input) throws Exception {
        BufferedImage image = ImageIO.read(input);
        int heigth = image.getHeight();
        int width = image.getWidth();
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = image.getRGB(j, j);
                matrixInput[i][j * 3] = (rgb >> 16) & 0xFF;
                matrixInput[i][j * 3 + 1] = (rgb >> 8) & 0xFF;
                matrixInput[i][j * 3 + 2] = rgb & 0xFF;
            }
        }
    }
}
