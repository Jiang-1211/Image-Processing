package source;

import static source.ImageIOProcessing.mergeRGB;

public class IdentityFilter {

    public static int[][] getIdentityFilter(int[][] pixelRed, int[][] pixelGreen, int[][] pixelBlue, int height, int width, int boxSize) {
        int[][] pixelIdentityFilter;

        pixelRed = doIdentityFilter(pixelRed, height, width, boxSize);
        pixelGreen = doIdentityFilter(pixelGreen, height, width, boxSize);
        pixelBlue = doIdentityFilter(pixelBlue, height, width, boxSize);

        pixelIdentityFilter = mergeRGB(pixelRed, pixelGreen, pixelBlue, height, width);

        return pixelIdentityFilter;
    }

    private static int[][] doIdentityFilter(int[][] pixelInput, int height, int width, int boxSize) {
        int[][] pixelIdentityFilter = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelIdentityFilter[i][j] = countIdentityFilter(pixelInput, boxSize, i, j);
            }
        }

        return pixelIdentityFilter;
    }

    private static int countIdentityFilter(int[][] pixelInput, int boxSize, int currentLength, int currentWidth) {
        int sum = 0;

        for (int i = currentLength - boxSize / 2; i <= currentLength + boxSize / 2; i++) {
            for (int j = currentWidth - boxSize / 2; j <= currentWidth + boxSize / 2; j++) {
                if (i == currentLength && j == currentWidth) {
                    sum = pixelInput[i][j];
                }
            }
        }

        return sum;
    }
}
