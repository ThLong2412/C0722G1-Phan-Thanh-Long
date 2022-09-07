package ss3_array_in_java.exersice;

import java.util.Arrays;
import java.util.Scanner;

public class Remove {
    public static void main(String[] args) {
        int size;
        int [] array ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size: ");
        size = scanner.nextInt();
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter element " + (i+1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Enter the element to be deleted: ");
        int delete = scanner.nextInt();
        int index_del = 0;
        for (int j = 0; j < array.length ; j++) {
            if (delete == array[j]) {
                index_del = j;
                System.out.println("the element to be deleted is at position: " + j);
                for (int k = j; k < array.length -1 ; k++) {
                    array[k] = array [(k+1)];
                } array[array.length - 1 ] = 0;
                System.out.println(" array new: " + Arrays.toString(array));
            }
        }

    }
}
