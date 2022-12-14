package ss1_introduction_to_java.exercise;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scanner.nextInt();
        if (number < 10 && number > 0) {
            switch (number) {
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
                case 5:
                    System.out.println("five");
                    break;
                case 6:
                    System.out.println("six");
                    break;
                case 7:
                    System.out.println("seven");
                    break;
                case 8:
                    System.out.println("eight");
                    break;
                case 9:
                    System.out.println("nine");
                    break;
                default:
                    System.out.println("out of ability");
                    break;
            }
        }
        else if (number < 20) {
//            String numberToWord3;
            switch (number) {
                case 10:
                    System.out.println("ten");
                    break;
                case 11:
                    System.out.println("eleven");
                    break;
                case 12:
                    System.out.println("twelve");
                    break;
                case 13:
                    System.out.println("thireen");
                    break;
                case 14:
                    System.out.println("fourteen");
                    break;
                case 15:
                    System.out.println("fifteen");
                    break;
                case 20:
                    System.out.println("twenty");
                    break;
                case 16:
                    System.out.println("sixteen");
                    break;
                case 17:
                    System.out.println("seventeen");
                    break;
                case 18:
                    System.out.println("eightteen");
                    break;
                case 19:
                    System.out.println("nineteen");
                    break;
            }
        }
        else if (number < 1000) {
            int hundred = number / 100;
            int tens = number / 10 % 10;
            int ones = number % 10;
            String numberToWord;
            switch (hundred) {
                case 1:
                    numberToWord = "one hundred";
                    break;
                case 2:
                    numberToWord = "two hundred";
                    break;
                case 3:
                    numberToWord = "three hundred";
                    break;
                case 4:
                    numberToWord = "hour hundred";
                    break;
                case 5:
                    numberToWord = "fife hundred";
                    break;
                case 6:
                    numberToWord = "six hundred";
                    break;
                case 7:
                    numberToWord = "seven hundred";
                    break;
                case 8:
                    numberToWord = "eight hundred";
                    break;
                case 9:
                    numberToWord = "nine hundred";
                    break;
                default:
                    numberToWord = " ";
            }
            String numberToWord1;
            switch (tens) {
                case 1:
                    numberToWord1 = "ten";
                    break;
                case 2:
                    numberToWord1 = "twenty";
                    break;
                case 3:
                    numberToWord1 = "thirty";
                    break;
                case 4:
                    numberToWord1 = "forty";
                    break;
                case 5:
                    numberToWord1 = "fifty";
                    break;
                case 6:
                    numberToWord1 = "sixty";
                    break;
                case 7:
                    numberToWord1 = "seventy";
                    break;
                case 8:
                    numberToWord1 = "eighty";
                    break;
                case 9:
                    numberToWord1 = "ninety";
                    break;
                default:
                    numberToWord1 = " ";
            }
            String numberToWord2;
            switch (ones) {
                case 1:
                    numberToWord2 = "one";
                    break;
                case 2:
                    numberToWord2 = "two";
                    break;
                case 3:
                    numberToWord2 = "three";
                    break;
                case 4:
                    numberToWord2 = "four";
                    break;
                case 5:
                    numberToWord2 = "five";
                    break;
                case 6:
                    numberToWord2 = "six";
                    break;
                case 7:
                    numberToWord2 = "seven";
                    break;
                case 8:
                    numberToWord2 = "eight";
                    break;
                case 9:
                    numberToWord2 = "nine";
                    break;
                default:
                    numberToWord2 = " ";
            }
            if(number < 120 && number > 110) {
//                String numberToWord3;
                switch (number) {
                    case 111:
                        System.out.println("one hundred eleven");
                        break;
                    case 112:
                        System.out.println("one hundred twelve");
                        break;
                    case 113:
                        System.out.println("one hundred thirteen ");
                        break;
                    case 114:
                        System.out.println("one hundred fourteen");
                        break;
                    case 115:
                        System.out.println("one hundred fifteen");
                        break;
                    case 116:
                        System.out.println("one hundred sixteen");
                        break;
                    case 117:
                        System.out.println("one hundred seventeen");
                        break;
                    case 118:
                        System.out.println("one hundred eighteen");
                        break;
                    case 119:
                        System.out.println("one hundred nineteen");
                        break;
                }
            }
            if (!numberToWord.equals(" ") || !numberToWord1.equals(" ")||!numberToWord2.equals(" ") ){
                System.out.printf("The number '%d' to words: %s !",number,numberToWord+" "+numberToWord1+" "+numberToWord2);
            }else{
                System.out.print("Invalid input!");
            }
        }
    }
}
