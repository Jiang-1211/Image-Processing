package source;

public class ContrastStretching {

    public static int[][] getContrastStretching(int[][] pixelInput, int height, int width) {
        int[][] pixelContrastStretching=new int[height][width*3];

        doContrastStretching(pixelContrastStretching, pixelInput, height, width, 0);
        doContrastStretching(pixelContrastStretching, pixelInput, height, width, 1);
        doContrastStretching(pixelContrastStretching, pixelInput, height, width, 2);

        return pixelContrastStretching;
    }

    private static void doContrastStretching(int[][] pixelContrastStretching, int[][] pixelInput, int height, int width, int color) {
        int maxValue = getMaxValue(pixelInput, height, width, color);
        int minValue = getMinValue(pixelInput, height, width, color);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelContrastStretching[i][j * 3 + color] = 255 * (pixelInput[i][j * 3 + color] - minValue) / (maxValue - minValue);
            }
        }
    }

    private static int getMaxValue(int[][] pixelInput, int height, int width, int color) {
        int maxValue = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (pixelInput[i][j * 3 + color] > maxValue) {
                    maxValue = pixelInput[i][j * 3 + color];
                }
            }
        }

        return maxValue;
    }

    private static int getMinValue(int[][] pixelInput, int height, int width, int color) {
        int minValue = 255;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (pixelInput[i][j * 3 + color] < minValue) {
                    minValue = pixelInput[i][j * 3 + color];
                }
            }
        }

        return minValue;
    }
}
