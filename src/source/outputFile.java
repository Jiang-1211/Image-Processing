package source;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class outputFile {
    public static void getPixel(int[][] matrixInput, File output, int width, int height) throws Exception {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int red = matrixInput[i][j * 3];
                int green = matrixInput[i][j * 3 + 1];
                int blue = matrixInput[i][j * 3 + 2];
                int rgb = (red << 16) | (green << 8) | blue;
                image.setRGB(i, j, rgb);
            }
        }
        ImageIO.write(image, "PNG", output);
    }
}
