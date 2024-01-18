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
        String folderPath="./Image";
        String inputImageName=getImageName(folderPath);
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of output image :");
        String outputImageName=scanner.nextLine();
        
        File input = new File(folderPath+"/"+inputImageName);
        File output = new File(folderPath+"/"+outputImageName+".jpeg");
        
        BufferedImage image = ImageIO.read(input);
        
        int height = image.getHeight();
        int width = image.getWidth();
        
        int[][] pixelRedInput = new int[height][width];
        int[][] pixelGreenInput = new int[height][width];
        int[][] pixelBlueInput = new int[height][width];
        
        int[][] pixelRedOutput;
        int[][] pixelGreenOutput;
        int[][] pixelBlueOutput;
        
        int[][] matrixOutput = new int[height][width * 3];
        
        inputImage(pixelRedInput, pixelGreenInput, pixelBlueInput, input);
        
        pixelRedOutput = getBoxFilter(pixelRedInput, height, width, 3);
        pixelGreenOutput = getBoxFilter(pixelGreenInput, height, width, 3);
        pixelBlueOutput = getBoxFilter(pixelBlueInput, height, width, 3);
        mergeRGB(pixelRedOutput, pixelGreenOutput, pixelBlueOutput, matrixOutput, height, width);
        
        outputImage(matrixOutput, width, height, output);
    }
}
