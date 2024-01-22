package source;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class TestFunction {

    public static int[][] testInput(File input) throws Exception {
        BufferedImage image = ImageIO.read(input);

        int height = image.getHeight();
        int width = image.getWidth();

        int[][] pixelInput = new int[height][width * 3];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = image.getRGB(j, i);
                pixelInput[i][j * 3] = (rgb >> 16) & 0xFF;
                pixelInput[i][j * 3 + 1] = (rgb >> 8) & 0xFF;
                pixelInput[i][j * 3 + 2] = rgb & 0xFF;
            }
        }

        return pixelInput;
    }

    public static int[][] testBoxFilter(int[][] pixelInput, int height, int width, int boxSize) {
        int[][] pixel = new int[height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixel[i][j * 3] = count(pixelInput, height, width, boxSize, i, j * 3);
                pixel[i][j * 3 + 1] = count(pixelInput, height, width, boxSize, i, j * 3 + 1);
                pixel[i][j * 3 + 2] = count(pixelInput, height, width, boxSize, i, j * 3 + 2);
            }
        }
        return pixel;
    }

    private static int count(int[][] pixelInput, int height, int width, int boxSize, int k, int l) {
        int sum = 0;
        for (int i = -boxSize / 2; i <= boxSize / 2; i++) {
            for (int j = -boxSize / 2; j <= boxSize / 2; j++) {
                if ((i + k) < 0 || (i + k) >= height || (j * 3 + l) < 0 || (j * 3 + l) >= width * 3) {
                    sum += 0;
                } else {
                    sum += pixelInput[i + k][j * 3 + l];
                }
            }
        }
        return (int) (sum / Math.pow(boxSize, 2));
    }
}
