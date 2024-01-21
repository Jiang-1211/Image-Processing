package source;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import static source.ContrastStretching.*;
import static source.MedianFilter.*;
import static source.IdentityFilter.*;
import static source.BoxFilter.*;
import static source.ImageIOProcessing.*;
import static source.ValueIOProcessing.*;

public class Main {

    public static void main(String[] args) throws Exception {
        while (true) {
            String[] filterName = {"Box Filter", "Identity Filter", "Median Filter",
                "Contrast Stretching", "Histogram Equalization", "Negative Transformation",
                "Log Transformation", "Gamma Transformation", "Alpha-Trimmed Mean Filter",
                "Laplace", "Sobel", "Motion Blurring"};
            String folderPath = "./Image";
            var inputImageName = getInputImageName(folderPath);

            if (inputImageName == null) {
                break;
            }

            String outputImageName = getOutputImageName();

            File input = new File(folderPath + "/" + inputImageName);
            File output = new File(folderPath + "/" + outputImageName + ".jpeg");

            BufferedImage image = ImageIO.read(input);

            int filterNumber = getFilterNumber(filterName);
            int height = image.getHeight();
            int width = image.getWidth();

            int[][] pixelRed = new int[height][width];
            int[][] pixelGreen = new int[height][width];
            int[][] pixelBlue = new int[height][width];

            int[][] pixelOutput = new int[height][width * 3];

            inputImage(pixelRed, pixelGreen, pixelBlue, input);

            switch (filterNumber) {
                case 1 -> {
                    int boxSize = getBoxSize();
                    pixelOutput = getBoxFilter(pixelRed, pixelGreen, pixelBlue, height, width, boxSize);
                    break;
                }
                case 2 -> {
                    int boxSize = getBoxSize();
                    pixelOutput = getIdentityFilter(pixelRed, pixelGreen, pixelBlue, height, width, boxSize);
                    break;
                }
                case 3 -> {
                    int boxSize=getBoxSize();
                    pixelOutput=getMedianFilter(pixelRed, pixelGreen, pixelBlue, height, width, boxSize);
                    break;
                }
                case 4 -> {
                    pixelOutput=getContrastStretching(pixelRed, pixelGreen, pixelBlue, height, width);
                    break;
                }
                case 5 -> {

                    break;
                }
                case 6 -> {

                    break;
                }
                case 7 -> {

                    break;
                }
                case 8 -> {

                    break;
                }
                case 9 -> {

                    break;
                }
                case 10 -> {

                    break;
                }
                case 11 -> {

                    break;
                }
                case 12 -> {

                    break;
                }
                default ->
                    throw new AssertionError();
            }

            outputImage(pixelOutput, height, width, output);
        }

    }
}
