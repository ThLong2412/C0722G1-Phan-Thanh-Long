package ss3_array_in_java.exersice;

import java.util.Scanner;

public class CharacterCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Your string is a: " + str);
        System.out.println("Enter the character you want to check: ");
        char characters = scanner.nextLine().charAt(0);
        int check = 0;
        char[]arr = str.toCharArray();
        for (int i = 0; i < arr.length ; i++) {
            if (characters == arr[i]) {
                check++;
            }
        }
        System.out.println("number of occurrences of the character " + characters + " in str is a: " + check);
    }
}
