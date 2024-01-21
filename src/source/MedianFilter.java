package source;

import java.util.Arrays;
import static source.ImageIOProcessing.mergeRGB;

public class MedianFilter {

    public static int[][] getMedianFilter(int[][] pixelRed, int[][] pixelGreen, int[][] pixelBlue, int height, int width, int boxSize) {
        int[][] pixelMedianFilter;

        pixelRed = doMedianFilter(pixelRed, height, width, boxSize);
        pixelGreen = doMedianFilter(pixelGreen, height, width, boxSize);
        pixelBlue = doMedianFilter(pixelBlue, height, width, boxSize);

        pixelMedianFilter = mergeRGB(pixelRed, pixelGreen, pixelBlue, height, width);

        return pixelMedianFilter;
    }

    private static int[][] doMedianFilter(int[][] pixelInput, int height, int width, int boxSize) {
        int[][] pixelMedianFilter = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelMedianFilter[i][j] = countMedianFilter(pixelInput, boxSize, i, j);
            }
        }

        return pixelMedianFilter;
    }

    private static int countMedianFilter(int[][] pixelInput, int boxSize, int currentLength, int currentWidth) {
        int pixelCount = 0;
        int[] pixelSort = new int[boxSize * boxSize];

        for (int i = currentLength - boxSize / 2; i <= currentLength + boxSize / 2; i++) {
            for (int j = currentWidth - boxSize / 2; j <= currentWidth + boxSize / 2; j++) {
                pixelSort[pixelCount] = pixelInput[i][j];
            }
        }

        Arrays.sort(pixelSort);

        if (pixelCount % 2 == 1) {
            return pixelSort[(pixelCount + 1) / 2 - 1];
        } else {
            return (pixelSort[pixelCount / 2 - 1] + pixelSort[pixelCount / 2 + 1 - 1]) / 2;
        }
    }
}
