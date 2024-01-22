package source;

public class BoxFilter {

    public static int[][] getBoxFilter(int[][] pixelInput, int height, int width, int boxSize) {
        int[][] pixelBoxFilter = new int[height][width * 3];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelBoxFilter[i][j * 3] = countBoxFilter(pixelInput, height, width, boxSize, i, j * 3);
                pixelBoxFilter[i][j * 3 + 1] = countBoxFilter(pixelInput, height, width, boxSize, i, j * 3 + 1);
                pixelBoxFilter[i][j * 3 + 2] = countBoxFilter(pixelInput, height, width, boxSize, i, j * 3 + 2);
            }
        }

        return pixelBoxFilter;
    }

    private static int countBoxFilter(int[][] pixelInput, int height, int width, int boxSize, int currentHeight, int currentWidth) {
        int sum = 0;

        for (int i = -boxSize / 2; i <= boxSize / 2; i++) {
            for (int j = -boxSize / 2; j <= boxSize / 2; j++) {
                if ((i + currentHeight) < 0 || (i + currentHeight) >= height || (j * 3 + currentWidth) < 0 || (j * 3 + currentWidth) >= width * 3) {
                    sum += 0;
                } else {
                    sum += pixelInput[i + currentHeight][j * 3 + currentWidth];
                }
            }
        }

        return sum /= Math.pow(boxSize, 2);
    }
}
