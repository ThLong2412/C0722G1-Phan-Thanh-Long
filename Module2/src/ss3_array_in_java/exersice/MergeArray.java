package ss3_array_in_java.exersice;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int size1;
        int size2;
        int[] array1;
        int[] array2;
        int[] array3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size1: ");
        size1 = scanner.nextInt();
        int i1 = 0;
        array1 = new int[size1];
        while (i1 < array1.length) {
            System.out.println("array[" + i1 + "] = ");
            array1[i1] = scanner.nextInt();
            i1++;
        }
        System.out.println("Enter size2: ");
        size2 = scanner.nextInt();
        int i2 = 0;
        array2 = new int[size2];
        while (i2 < array2.length) {
            System.out.println("array[" + i2 + "] = ");
            array2[i2] = scanner.nextInt();
            i2++;
        }
        System.out.println("size a array3: ");
        int size3 = size1 + size2;
        int i3 = 0;
        array3 = new int[size3];
        i2=0;
        while (i3 < array1.length) {
            array3[i3] = array1[i3];
            i3++;
        }
        i3 = 0;
        while (i3 < array2.length) {
            array3[i3 + size1] = array2[i2];
            i2++;
            i3++;
        }
        System.out.println("array3" + Arrays.toString(array3) );
    }
}
