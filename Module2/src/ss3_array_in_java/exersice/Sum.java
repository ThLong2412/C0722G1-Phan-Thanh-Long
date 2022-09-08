package ss3_array_in_java.exersice;

import java.util.Arrays;
import java.util.Scanner;

public class Sum {
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
        int sum = 0;
        System.out.println("enter the column you want to sum: ");
        int numberColumn = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < array[i-1].length ; j++) {
            if (numberColumn == array[i-1][j]) {
                for (int k = 0; k <array.length ; k++) {
                    sum += array[k][numberColumn];
                }
            }
        }
        System.out.println("sum of osos in column " + numberColumn + " is a: " + sum);
    }
}
