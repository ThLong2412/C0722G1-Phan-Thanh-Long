package ss3_array_in_java.exersice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class FindMaxTwoDimensionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [][] array;
        System.out.println("large array number: ");
        int sizeGreat = Integer.parseInt(scanner.nextLine());
        System.out.println("small array number: ");
        int sizeSmall = Integer.parseInt(scanner.nextLine());
        array = new int[sizeGreat][sizeSmall];
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < array[sizeGreat - 1].length; j++) {
                System.out.println("Enter a array[" + i + "][" + j + "]");
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
            i++;
        }
        for (int j = 0; j < sizeGreat ; j++) {
            System.out.println(Arrays.toString(array[j]));
        }

        int max = array[0][0];
        for (int k = 0; k < array.length ; k++) {
            for (int l = 0; l < array[sizeGreat - 1].length ; l++) {
                if(max < array[k][l]) {
                    max = array[k][l];
                }
            }
        }
        System.out.println("The largest value in the array is: " + max);
    }
}
