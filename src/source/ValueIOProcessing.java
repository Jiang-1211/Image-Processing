package source;

import java.util.Scanner;

public class ValueIOProcessing {

    public static String getOutputImageName() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the name of output image : ");
        String outputImageName = scanner.nextLine();
        
        System.out.println("------------------------------");
        
        return outputImageName;
    }
    
    public static int getFilterNumber(String[] filterName){
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
        int bosSize = scanner.nextInt();
        
        System.out.println("------------------------------");

        while (bosSize < 1) {
            System.out.print("Please enter available number : ");
            bosSize = scanner.nextInt();
            
            System.out.println("------------------------------");
        }
        
        return bosSize;
    }
}
