package source;

import java.util.Arrays;

public class MedianFilter {

    public static int[][] getMedianFilter(int[][] pixelInput, int height, int width, int boxSize) {
        int[][] pixelMedianFilter = new int[height][width * 3];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelMedianFilter[i][j * 3] = countMedianFilter(pixelInput, height, width, boxSize, i, j * 3);
                pixelMedianFilter[i][j * 3 + 1] = countMedianFilter(pixelInput, height, width, boxSize, i, j * 3 + 1);
                pixelMedianFilter[i][j * 3 + 2] = countMedianFilter(pixelInput, height, width, boxSize, i, j * 3 + 2);
            }
        }

        return pixelMedianFilter;
    }

    private static int countMedianFilter(int[][] pixelInput, int height, int width, int boxSize, int currentHeight, int currentWidth) {
        int pixelCount = 0;
        int[] pixelSort = new int[boxSize * boxSize];

        for (int i = -boxSize / 2; i <= +boxSize / 2; i++) {
            for (int j = -boxSize / 2; j <= boxSize / 2; j++) {
                if ((i + currentHeight) >= 0 && (i + currentHeight) < height && (j * 3 + currentWidth) >= 0 && (j * 3 + currentWidth) < width * 3) {
                    pixelSort[pixelCount] = pixelInput[i + currentHeight][j * 3 + currentWidth];
                    pixelCount++;
                }
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
