package ss19_string_and_amp_regex.exercise.ss2_validate_phone_numbers;

import java.util.Scanner;

public class RegularExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại");
        String numbersPhone = scanner.nextLine();
        if (numbersPhone.matches("^[(][0-9]{2}[)][-][(][0][0-9]{9}[)]$")){
            System.out.println(numbersPhone + ": Đúng định dạng");
        } else {
            System.out.println(numbersPhone + ": Sai định dạng");
        }
    }
}
