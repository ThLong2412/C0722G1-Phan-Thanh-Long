package ss3_array_in_java.exersice;

import java.util.Arrays;
import java.util.Scanner;

public class SumAtDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] array;
        System.out.println("large array number and small array number: ");
        int sizeGreat = Integer.parseInt(scanner.nextLine());
        int sizeSmall = sizeGreat;
        array = new int[sizeGreat][sizeSmall];
        int i = 0;
        while (i < array.length) {
            for (int j = 0; j < array[sizeGreat - 1].length; j++) {
                System.out.println("Enter a array[" + i + "][" + j + "]");
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
            i++;
        }
        for (int j = 0; j < sizeGreat; j++) {
            System.out.println(Arrays.toString(array[j]));
        }
        int k = 0;
        int sum = 0;
        while ( k < array.length) {
            sum += array[k][k];
            k++;
        }
        k = array.length - 1;
        while (k >= 0) {
            sum += array[k][k];
            k--;
        }
        System.out.println("Your sum is a: " + sum);
    }
}
