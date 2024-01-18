package source;

public class BoxFilter {

    public static int[][] getBoxFilter(int[][] matrixInput, int height, int width, int boxSize) {
        int[][] matrixBoxFilter = new int[height][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrixBoxFilter[i][j] = countBoxFilter(matrixInput, height, width, boxSize, i, j);
            }
        }
        return matrixBoxFilter;
    }

    private static int countBoxFilter(int[][] matrixInput, int height, int width, int boxSize, int currentLength, int currentWidth) {
        int sum = 0;
        for (int i = currentLength - boxSize / 2; i <= currentLength + boxSize / 2; i++) {
            for (int j = currentWidth - boxSize / 2; j <= currentWidth + boxSize / 2; j++) {
                if (i < 0 || i >= height || j < 0 || j >= width) {
                    sum += 0;
                } else {
                    sum += matrixInput[i][j];
                }
            }
        }
        sum /= Math.pow(boxSize, 2);
        return sum;
    }
}
