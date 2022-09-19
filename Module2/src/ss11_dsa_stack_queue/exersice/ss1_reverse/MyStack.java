package ss11_dsa_stack_queue.exersice.ss1_reverse;

import java.util.Scanner;
import java.util.Stack;

public class MyStack {
    public static void main(String[] args) {

        while (true) {
            Stack<Integer> myStack = new Stack<>();
            Stack<Integer> myStack1 = new Stack<>();
            Stack<Character> wStack = new Stack<>();
            Stack<Character> mWord = new Stack<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. đảo mảng số nguyên");
            System.out.println("2. đảo ký tự chuỗi");
            System.out.println("Mời bạn lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("nhập n");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("nhập phần tử ở vị trí: " + i);
                        myStack.push(scanner.nextInt());
                    }

                    System.out.println("Stack ban đầu là: " + myStack + "\n");

                    for (int i = 0; i < n; i++) {
                        myStack1.push(myStack.pop());
                    }

                    System.out.println("Stack sau khi đảo ngược là: " + myStack1);
                    break;
                case 2:
                    System.out.println("Nhập chuỗi: ");
                    String string = scanner.nextLine();
                    char[] arrChar = string.toCharArray();
                    for (int i = 0; i < arrChar.length; i++) {
                        mWord.push(arrChar[i]);
                    }
                    System.out.println("Các kí tự của chuỗi nhập vào là: " + mWord);

                    for (int i = 0; i < arrChar.length; i++) {
                        wStack.push(mWord.pop());
                    }

                    System.out.println("Các kí tự sau khi dảo ngược là: " + wStack);
                    break;
                case 3:
                    System.exit(0);
                    return;
                default:
                    System.out.println("vui lòng lựa chọn lại");
                    break;
            }

        }

    }
}
