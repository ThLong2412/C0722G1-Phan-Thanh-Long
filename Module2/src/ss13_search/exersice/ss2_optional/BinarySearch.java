package ss13_search.exersice.ss2_optional;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập đồ dài mảng");
        int size = Integer.parseInt(scanner.nextLine());
        int[] array;
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("array[" + i + "] = ");
            array[i] = scanner.nextInt();
            i++;
        }
        sortASC(array);
        System.out.println("Array sau khi sắp xếp là: " + Arrays.toString(array));

        System.out.println(binarySearch(array, 0, array.length - 1, 40));
    }

    public static void sortASC(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static String binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return "số cần tìm vở vị trí " + middle;
        } else if (array[middle] < value) {
            return binarySearch(array, middle + 1, right, value);
        }
        return binarySearch(array, left, middle - 1, value);
    }
}
