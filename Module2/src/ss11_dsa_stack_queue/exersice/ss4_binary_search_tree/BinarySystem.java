package ss11_dsa_stack_queue.exersice.ss4_binary_search_tree;

import java.util.Scanner;
import java.util.Stack;

public class BinarySystem {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số thập phân cần đổi");
        int number = Integer.parseInt(scanner.nextLine());
        while (number >= 1) {
            stack.push(number % 2);
            number = number / 2;
        }
        int size = stack.size();
        String result = "";
        for (int i = 0; i < size ; i++) {
            result += stack.pop();
        }
        System.out.println("số nhị phân của là: " +result);
    }
}
