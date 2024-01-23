package source;

import java.io.File;
import java.util.Scanner;

public class ValueIOProcessing {

    public static String getInputImageName(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Please put images in the \"Image\" folder !");
            System.out.println("------------------------------");

            return null;
        } else {
            for (int i = 0; i < files.length; i++) {
                System.out.printf("%5s : %s%n", i + 1, files[i].getName());
            }

            System.out.println("------------------------------");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the image or enter 0 to exit : ");
            int num = scanner.nextInt();

            System.out.println("------------------------------");

            while (num < 0 || num > files.length) {
                System.out.print("Please enter available number : ");
                num = scanner.nextInt();

                System.out.println("------------------------------");
            }

            if (num == 0) {
                return null;
            }

            return files[num - 1].getName();
        }
    }

    public static String getOutputImageName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of output image : ");
        String outputImageName = scanner.nextLine();

        System.out.println("------------------------------");

        return outputImageName;
    }

    public static int getFilterNumber(String[] filterName) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < filterName.length; i++) {
            System.out.printf("%5s : %s%n", i + 1, filterName[i]);
        }

        System.out.println("------------------------------");

        System.out.print("Enter the number of filter : ");
        int filterNumber = scanner.nextInt();

        System.out.println("------------------------------");

        while (filterNumber <= 0 || filterNumber > filterName.length) {
            System.out.print("Please enter available number : ");
            filterNumber = scanner.nextInt();

            System.out.println("------------------------------");
        }

        return filterNumber;
    }

    public static int getBoxSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size N of the NxN box : ");
        int boxSize = scanner.nextInt();

        System.out.println("------------------------------");

        while (boxSize < 1) {
            System.out.print("Please enter available number : ");
            boxSize = scanner.nextInt();

            System.out.println("------------------------------");
        }

        return boxSize;
    }

    public static double getGamma() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the gamma value : ");
        double gamma = scanner.nextDouble();

        System.out.println("------------------------------");

        while (gamma < 0) {
            System.out.print("Please enter available number : ");
            gamma = scanner.nextDouble();

            System.out.println("------------------------------");
        }

        return gamma;
    }
}
