package ss3_array_in_java.exersice;

import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size: ");
        size = Integer.parseInt(scanner.nextLine());
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("array[" + i + "]");
            array[i] = Integer.parseInt(scanner.nextLine());
            i++;
        }
        int min = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        System.out.println(" Min value in array is a: " + min);
    }
}
