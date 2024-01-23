package source;

public class LogTransformation {

    public static int[][] getLogTransformation(int[][] pixelInput, int height, int width, int c) {
        int[][] pixelLog = new int[height][width * 3];

        doLogTransformation(pixelLog, pixelInput, height, width, c, 0);
        doLogTransformation(pixelLog, pixelInput, height, width, c, 1);
        doLogTransformation(pixelLog, pixelInput, height, width, c, 2);

        return pixelLog;
    }

    private static void doLogTransformation(int[][] pixelLog, int[][] pixelInput, int height, int width, int c, int color) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelLog[i][j * 3 + color] = (int) (c * Math.log10(1 + pixelInput[i][j * 3 + color]));
            }
        }
    }
}
