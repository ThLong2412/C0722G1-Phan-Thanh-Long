package ss19_string_and_amp_regex.exercise.ss1_validate_name_class;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String NAME_CLASS = "^[ACP][0-9]{4}[G-M]$";

    public RegularExpression() {
        pattern = Pattern.compile(NAME_CLASS);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
     return matcher.matches();
    }

    public static void main(String[] args) {
        RegularExpression regularExpression = new RegularExpression();
        Scanner scanner =  new Scanner(System.in);
        System.out.println("Nhập tên class");
        String className = scanner.nextLine();
        boolean result = regularExpression.validate(className);
        System.out.println("Class name is " + className + " is valid: " + result);
    }
}

