package source;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

import static source.FileIOProcessing.*;
import static source.ImageIOProcessing.*;
import static source.BoxFilter.*;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] filterName = {"Box Filter"};
        String folderPath = "./Image";
        String inputImageName = getImageName(folderPath);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of output image :");
        String outputImageName = scanner.nextLine();

        File input = new File(folderPath + "/" + inputImageName);
        File output = new File(folderPath + "/" + outputImageName + ".jpeg");

        BufferedImage image = ImageIO.read(input);

        int height = image.getHeight();
        int width = image.getWidth();

        int[][] pixelRed= new int[height][width];
        int[][] pixelGreen = new int[height][width];
        int[][] pixelBlue = new int[height][width];

        int[][] pixelOutput = new int[height][width * 3];

        inputImage(pixelRed, pixelGreen, pixelBlue, input);

        for (int i = 0; i < filterName.length; i++) {
            System.out.printf("%5s : %s%n", i + 1, filterName[i]);
        }

        System.out.print("Enter the number of filter :");
        int filterNumber = scanner.nextInt();

        while (filterNumber <= 0 || filterNumber > filterName.length) {
            System.out.print("Please enter available number :");
            filterNumber = scanner.nextInt();
        }

        switch (filterNumber) {
            case 1:
                System.out.print("Enter the size N of the NxN box :");
                int bosSize = scanner.nextInt();

                while (bosSize < 1) {
                    System.out.print("Please enter available number :");
                    filterNumber = scanner.nextInt();
                }

                pixelOutput=getBoxFilter(pixelRed, pixelGreen, pixelBlue, height, width, bosSize);
                
                break;
            default:
                throw new AssertionError();
        }

        outputImage(pixelOutput, width, height, output);
    }
}
