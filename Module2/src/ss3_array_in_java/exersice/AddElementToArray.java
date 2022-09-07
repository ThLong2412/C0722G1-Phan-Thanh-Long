package ss3_array_in_java.exersice;

import com.sun.javaws.IconUtil;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size: ");
        size = scanner.nextInt();
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("array[" + i + "] = ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("enter the number to insert: ");
        int number = scanner.nextInt();
        System.out.println("enter the location to insert: ");
        int index_insert = scanner.nextInt();
        if (index_insert <= -1 || index_insert >= array.length - 1) {
            System.out.println("Unable to insert element into array.");
        }
//        int temp = 0;
//        int temp2 = 0;
//        for (int j = 0; j < array.length - 1; j++) {
//            if (index_insert == j) {
//                temp = array[j];
//                temp2 = array[j + 1];
//                array[j] = number;
//                array[j + 1] = temp;
//                array[j + 2] = temp2;
//                System.out.println(" array new: " + Arrays.toString(array));
//            }
//        }
        for (int j = array.length - 1; j > index_insert ; j--) {
            array[j] = array[j-1];
        } array[index_insert] = number;
        System.out.println(" array new: " + Arrays.toString(array));
    }
}
