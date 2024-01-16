package source;

public class boxFilter {
    public static int[][] getBoxFilter(int[][] matrixInput, int length, int width, int boxSize) {
        int[][] matrixBoxFilter = new int[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                matrixBoxFilter[i][j] = countBoxFilter(matrixInput, length, width, boxSize, i, j);
            }
        }
        return matrixBoxFilter;
    }

    private static int countBoxFilter(int[][] matrixInput, int length, int width, int boxSize, int currentLength,
            int currentWidth) {
        int sum = 0;
        for (int i = currentLength - boxSize / 2; i <= currentLength + boxSize / 2; i++) {
            for (int j = currentWidth - boxSize / 2; j <= currentWidth + boxSize / 2; j++) {
                if (i < 0 || i >= length || j < 0 || j >= width) {
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
