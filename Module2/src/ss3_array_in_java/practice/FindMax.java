package ss3_array_in_java.practice;

import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class FindMax {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);
        int i = 0;
        array = new int[size];
        while (i < array.length) {
            System.out.println("array[" + i + "]");
            array[i] = scanner.nextInt();
            i++;
        }
        int max = array[0];
        int index_max = 0;
        for (int j = 0; j < array.length; j++) {
            if(array[j] > max) {
                max = array[j];
                index_max = j;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index_max);
    }
}
