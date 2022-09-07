package ss3_array_in_java.practice;

import java.util.Scanner;

public class FindValueInArray {
    public static void main(String[] args) {
        String [] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name student");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length ; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Position of the students in the list " + input_name + " is: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Not found in the list.");
        }
    }
}
