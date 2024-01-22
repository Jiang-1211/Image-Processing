package source;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageIOProcessing {

    public static int[][] getInputImage(File input) throws Exception {
        BufferedImage image = ImageIO.read(input);

        int height = image.getHeight();
        int width = image.getWidth();
        
        int[][] pixelInput=new int[height][width*3];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = image.getRGB(j, i);
                pixelInput[i][j*3] = (rgb >> 16) & 0xFF;
                pixelInput[i][j*3+1] = (rgb >> 8) & 0xFF;
                pixelInput[i][j*3+2] = rgb & 0xFF;
            }
        }
        
        return pixelInput;
    }

    public static void outputImage(int[][] pixelOutput, int height, int width, File output) throws Exception {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int red = pixelOutput[i][j * 3];
                int green = pixelOutput[i][j * 3 + 1];
                int blue = pixelOutput[i][j * 3 + 2];
                int rgb = (red << 16) | (green << 8) | blue;
                image.setRGB(j, i, rgb);
            }
        }
        ImageIO.write(image, "jpeg", output);
    }
}
