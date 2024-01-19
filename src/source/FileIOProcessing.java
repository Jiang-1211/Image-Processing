package source;

import java.io.File;
import java.util.Scanner;

public class FileIOProcessing {

    public static String getImageName(String folderPath) {
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
            
            if(num==0)
            {
                return null;
            }

            return files[num - 1].getName();
        }
    }
}
