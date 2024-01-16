package source;

import java.io.*;
import java.util.Scanner;
// import source.boxFilter;

public class main {
    public static void main(String[] args) {
        int num = 1024;
        System.out.println(num);
        System.out.println(num >> 1);
        System.out.println((num >> 1) & 0xff);
        System.out.println(num << 1);
        String filePath = "./image/test.ppm";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    // 讀取整數
                    int intValue = scanner.nextInt();
                    System.out.println("整數: " + intValue);
                } else {
                    // 讀取字串
                    String stringValue = scanner.next();
                    System.out.println("字串: " + stringValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
