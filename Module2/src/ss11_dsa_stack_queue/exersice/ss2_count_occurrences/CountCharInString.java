package ss11_dsa_stack_queue.exersice.ss2_count_occurrences;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class CountCharInString {
    public static void main(String[] args) {
        TreeMap <String, Integer> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String [] stringArr = str.toLowerCase().split(" ");

        for (String key: stringArr) {
            if (!map.containsKey(key)){
                map.put(key,1);
            }else {
                Integer value = map.get(key);
                value ++;
                map.replace(key,value);
            }
        }
        System.out.println(map);
    }
}

