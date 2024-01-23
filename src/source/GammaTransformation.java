package source;

public class GammaTransformation {

    public static int[][] getGammaTransformation(int[][] pixelInput, int height, int width, double gamma, int c) {
        int[][] pixelGamma = new int[height][width * 3];

        doGammaTransformation(pixelGamma, pixelInput, height, width, gamma, c, 0);
        doGammaTransformation(pixelGamma, pixelInput, height, width, gamma, c, 1);
        doGammaTransformation(pixelGamma, pixelInput, height, width, gamma, c, 2);

        return pixelGamma;
    }

    private static void doGammaTransformation(int[][] pixelGamma, int[][] pixelInput, int height, int width, double gamma, int c, int color) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixelGamma[i][j * 3 + color] = (int) (255 * c * Math.pow((double) pixelInput[i][j * 3 + color] / 255, gamma));
            }
        }
    }
}
