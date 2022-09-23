package ss14_sort_algorithm.practice.pr3;

import java.util.Arrays;

public class SelectionSortSetting {
    public static void selectionSortSetting(double [] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            double min = array[i];
            for (int j = i +1; j < array.length; j++){
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }

    public static void main(String[] args) {
        double [] arr = {-1,6,12,-3,-9,5,8,-11};
        selectionSortSetting(arr);
        System.out.println(Arrays.toString(arr));
    }
}
