package source;

public class NegativaTransformation {

    public static int[][] getNegative(int[][] pixelInput, int height, int width) {
        int[][] pixelNegative = new int[height][width * 3];

        doNegative(pixelNegative, pixelInput, height, width, 0);
        doNegative(pixelNegative, pixelInput, height, width, 1);
        doNegative(pixelNegative, pixelInput, height, width, 2);

        return pixelNegative;
    }

    private static void doNegative(int[][] pixelNegative, int[][] pixelInput, int height, int width, int color) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelNegative[i][j * 3 + color] = 255 - pixelInput[i][j * 3 + color];
            }
        }
    }
}
