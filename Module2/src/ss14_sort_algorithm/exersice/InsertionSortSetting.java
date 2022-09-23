package ss14_sort_algorithm.exersice;

import java.util.Arrays;

public class InsertionSortSetting {
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int [] array = {5,1,30,-2,78,-96,54,-11,3};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

}
