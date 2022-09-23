package ss14_sort_algorithm.exersice;

import java.util.Arrays;

public class InsertionSortIllustration {
    public static void insertionSortIllustration(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                    System.out.println("\n array[" + (j+1) + "] = " + array[j]);
                j--;
            }
            System.out.println("\nthen array = " + Arrays.toString(array));
            array[j + 1] = temp;
            System.out.println("\nthen array[" + (j + 1) + "] = " + temp);
        }
    }

    public static void main(String[] args) {
        int[] array = {2, -9, 8, 11, -15, 3, 4, 2, -6, 11};
        insertionSortIllustration(array);
        System.out.println("\narray after: " + Arrays.toString(array));
    }
}
