package ss13_search.exersice.ss1_string;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập chuỗi");
        String string = scanner.nextLine();
        LinkedList<Character> listMax = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> listTemp = new LinkedList<>();
            listTemp.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > listTemp.getLast()) // trả về phần tử cuối cùng của linkedlist
                {
                    listTemp.add(string.charAt(j));
                }
            }
            if (listTemp.size() > listMax.size()) {
                listMax.clear();
                listMax.addAll(listTemp);
            }
            listTemp.clear();
        }
        for (Character ch : listMax) {
            System.out.print(ch);
        }
    }
}
