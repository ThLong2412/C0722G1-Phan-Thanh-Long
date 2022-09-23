package ss14_sort_algorithm.practice.pr1;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortSetting {
    public static void bubbleSort(int [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i ; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập độ dài mảng");
        int size = Integer.parseInt(scanner.nextLine());
        int [] array;
        array = new int[size];
         int i = 0;
         while (i < size) {
             System.out.println("array[" + i +"] =");
             array[i] = scanner.nextInt();
             i++;
         }
         bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
