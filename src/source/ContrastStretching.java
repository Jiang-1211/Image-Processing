package source;

import static source.ImageIOProcessing.mergeRGB;

public class ContrastStretching {

    public static int[][] getContrastStretching(int[][] pixelRed, int[][] pixelGreen, int[][] pixelBlue, int height, int width) {
        int[][] pixelContrastStretching;

        pixelRed = doContrastStretching(pixelRed, height, width);
        pixelGreen = doContrastStretching(pixelGreen, height, width);
        pixelBlue = doContrastStretching(pixelBlue, height, width);

        pixelContrastStretching = mergeRGB(pixelRed, pixelGreen, pixelBlue, height, width);

        return pixelContrastStretching;
    }

    private static int[][] doContrastStretching(int[][] pixelInput, int height, int width) {
        int[][] pixelContrastStretching = new int[height][width];
        int maxValue = getMaxValue(pixelInput, height, width);
        int minValue = getMinValue(pixelInput, height, width);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelContrastStretching[i][j] = countContrastStretching(pixelInput[i][j], maxValue, minValue);
            }
        }

        return pixelContrastStretching;
    }

    private static int getMaxValue(int[][] pixelInput, int height, int width) {
        int maxValue = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(pixelInput[i][j]>maxValue){
                    maxValue=pixelInput[i][j];
                }
            }
        }
        
        return maxValue;
    }

    private static int getMinValue(int[][] pixelInput, int height, int width) {
        int minValue = 255;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (pixelInput[i][j] < minValue) {
                    minValue = pixelInput[i][j];
                }
            }
        }

        return minValue;
    }

    private static int countContrastStretching(int pixelValue, int maxValue, int minValue) {
        final int MAX_PIXEL=255;
        
        return MAX_PIXEL*(pixelValue-minValue)/(maxValue-minValue);
    }
}
