package source;

import static source.ImageIOProcessing.*;

public class BoxFilter {

    public static int[][] getBoxFilter(int[][] pixelRed, int[][] pixelGreen, int[][] pixelBlue, int height, int width, int boxSize) {
        int[][] pixelBoxFilter = new int[height][width * 3];

        pixelRed=doBoxFilter(pixelRed, height, width, boxSize);
        pixelGreen=doBoxFilter(pixelGreen, height, width, boxSize);
        pixelBlue=doBoxFilter(pixelBlue, height, width, boxSize);
        
        pixelBoxFilter=mergeRGB(pixelRed, pixelGreen, pixelBlue, height, width);

        return pixelBoxFilter;
    }
    
    private static int [][] doBoxFilter(int [][] pixelInput,int height,int width,int boxSize){
        int[][] pixelBoxFilter = new int[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelBoxFilter[i][j] = countBoxFilter(pixelInput, height, width, boxSize, i, j);
            }
        }
        
        return pixelBoxFilter;
    }

    private static int countBoxFilter(int[][] pixelInput, int height, int width, int boxSize, int currentLength, int currentWidth) {
        int sum = 0;

        for (int i = currentLength - boxSize / 2; i <= currentLength + boxSize / 2; i++) {
            for (int j = currentWidth - boxSize / 2; j <= currentWidth + boxSize / 2; j++) {
                if (i < 0 || i >= height || j < 0 || j >= width) {
                    sum += 0;
                } else {
                    sum += pixelInput[i][j];
                }
            }
        }

        return sum /= Math.pow(boxSize, 2);
    }
}
