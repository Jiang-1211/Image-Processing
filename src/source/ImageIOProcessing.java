package source;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageIOProcessing {

    public static void inputImage(int[][] pixelRed, int[][] pixelGreen, int[][] pixelBlue, File input) throws Exception {
        BufferedImage image = ImageIO.read(input);

        int heigth = image.getHeight();
        int width = image.getWidth();

        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = image.getRGB(j, i);
                pixelRed[i][j] = (rgb >> 16) & 0xFF;
                pixelGreen[i][j] = (rgb >> 8) & 0xFF;
                pixelBlue[i][j] = rgb & 0xFF;
            }
        }
    }

    public static void outputImage(int[][] matrixInput, int width, int height, File output) throws Exception {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int red = matrixInput[i][j * 3];
                int green = matrixInput[i][j * 3 + 1];
                int blue = matrixInput[i][j * 3 + 2];
                int rgb = (red << 16) | (green << 8) | blue;
                image.setRGB(j, i, rgb);
            }
        }
        ImageIO.write(image, "jpeg", output);
    }

    public static int[][] mergeRGB(int[][] pixelRed, int[][] pixelGreen, int[][] pixelBlue,int height, int width) {
        int[][] pixelOutput=new int[height][width*3];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelOutput[i][j * 3] = pixelRed[i][j];
                pixelOutput[i][j * 3 + 1] = pixelGreen[i][j];
                pixelOutput[i][j * 3 + 2] = pixelBlue[i][j];
            }
        }
        
        return pixelOutput;
    }
}
