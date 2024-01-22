package source;

public class IdentityFilter {

    public static int[][] getIdentityFilter(int[][] pixelInput, int height, int width, int boxSize) {
        int[][] pixelIdentityFilter = new int[height][width * 3];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelIdentityFilter[i][j * 3] = countIdentityFilter(pixelInput, boxSize, i, j * 3);
                pixelIdentityFilter[i][j * 3 + 1] = countIdentityFilter(pixelInput, boxSize, i, j * 3 + 1);
                pixelIdentityFilter[i][j * 3 + 2] = countIdentityFilter(pixelInput, boxSize, i, j * 3 + 2);
            }
        }

        return pixelIdentityFilter;
    }

    private static int countIdentityFilter(int[][] pixelInput, int boxSize, int currentHeight, int currentWidth) {
        int sum = 0;

        for (int i = -boxSize / 2; i <= boxSize / 2; i++) {
            for (int j = -boxSize / 2; j <= boxSize / 2; j++) {
                if ((i + currentHeight) == currentHeight && (j * 3 + currentWidth) == currentWidth) {
                    sum = pixelInput[i + currentHeight][j * 3 + currentWidth];
                }
            }
        }

        return sum;
    }
}
