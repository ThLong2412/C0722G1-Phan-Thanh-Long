package ss11_dsa_stack_queue.exersice.ss5_string_palindrome;


import java.util.*;

//nam choi da ad iohc man
public class Palindrome {
    public static void main(String[] args) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi");
        String string = scanner.nextLine();
        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            stack.push(charArray[i]);
            queue.add(charArray[i]);
        }
        int size = stack.size();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (stack.peek().equals(queue.peek())) {
                count += 1;
            }
        }
        if (count == size) {
            System.out.println("is palindrome");
        } else {
            System.out.println("not is are palindrome");
        }
    }
}
