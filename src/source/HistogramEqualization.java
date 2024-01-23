package source;

public class HistogramEqualization {

    public static int[][] getHistogram(int[][] pixelInput, int height, int width) {
        int[][] pixelHistogram = new int[height][width * 3];

        doHistogram(pixelHistogram, pixelInput, height, width, 0);
        doHistogram(pixelHistogram, pixelInput, height, width, 1);
        doHistogram(pixelHistogram, pixelInput, height, width, 2);

        return pixelHistogram;
    }

    private static void doHistogram(int[][] pixelHistogram, int[][] pixelInput, int height, int width, int color) {
        int[] possibility = getPossibility(pixelInput, height, width, color);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelHistogram[i][j * 3 + color] = (255 * possibility[pixelInput[i][j * 3 + color]]) / (height * width);
            }
        }
    }

    private static int[] getPossibility(int[][] pixelInput, int height, int width, int color) {
        int[] possibility = new int[256];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                possibility[pixelInput[i][j * 3 + color]]++;
            }
        }

        for (int i = 0; i < 255; i++) {
            possibility[i + 1] += possibility[i];
        }

        return possibility;
    }
}
