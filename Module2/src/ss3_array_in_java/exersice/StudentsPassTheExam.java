package ss3_array_in_java.exersice;

import java.util.Scanner;

public class StudentsPassTheExam {
    public static void main(String[] args) {
        int[] array;
        int size;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = Integer.parseInt(scanner.nextLine());
            if (size > 30) {
                System.out.println("Size should not exceed 30");
            }
        } while (size > 30);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("array[" + i + "]");
            array[i] = Integer.parseInt(scanner.nextLine());
            i++;
        }
        int count = 0;
        for (int j = 0; j < array.length ; j++) {
            if (array[j] >= 5 && array[j] <= 10) {
                count+=1;
            }
        }
        System.out.println("list of students who passed the exam: " + count);
    }
}
