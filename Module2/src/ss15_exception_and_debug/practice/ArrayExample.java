package ss15_exception_and_debug.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer [] createRandom() {
        Random random = new Random();
        Integer [] array = new Integer[100];
        for (int i = 0; i < 100; i++) {
            System.out.println("Phần tử thứ " + i + " là: ");
            array[i] = random.nextInt(100);
            System.out.println(array[i]);
        }
        return array;
    }

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer [] arr = arrayExample.createRandom();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chỉ số cần tìm kiếm: ");
        int x = Integer.parseInt(scanner.nextLine());
        try {
            System.out.println("Phần tử ở vị trí " + x + " có giá trị: " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Chỉ số không nằm trong miền mảng.");
        }
    }
}
