package source;

import java.io.File;
import java.util.Scanner;

public class FileIOProcessing {

    public static String getImageName(String folderPath) {
        int num;

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Please put images in the \"Image\" folder !");

            return null;
        } else {
            for (int i = 0; i < files.length; i++) {
                System.out.printf("%5s : %s%n",i+1,files[i].getName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the image :");
            num = scanner.nextInt();

            while (num <= 0 || num > files.length) {
                System.out.print("Please enter available number :");
                num = scanner.nextInt();
            }

            return files[num - 1].getName();
        }
    }
}
