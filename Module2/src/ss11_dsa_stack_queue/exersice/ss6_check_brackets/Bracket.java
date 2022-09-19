package ss11_dsa_stack_queue.exersice.ss6_check_brackets;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Stack<String> bracketStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập biểu thức");
        String string = scanner.nextLine();
        boolean test = true;
        String left = "";
        String [] charArray = string.split("");
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i].equals("(")) {
                bracketStack.push(charArray[i]);
            } else if (charArray[i].equals(")")) {
                if (bracketStack.isEmpty()) {
                    test = false;
                    break;
                } else {
                    left = bracketStack.pop();
                    if (!left.equals("(") || !charArray[i].equals(")")) {
                        test = false;
                        break;
                    }
                }
            }
            if (i == charArray.length - 1) {
                test = bracketStack.isEmpty();
            }
        }
        if (test) {
            System.out.println("Well !!!!!!!");
        } else {
            System.out.println("notWell >>>>>>");
        }
    }
}
