package ss2_loop_in_java.exersice;
public class PrimesLessThan100 {
    public static void main(String[] args) {
        int check = 0;
        int number = 2;
        String result = "";
        while (number < 100) {
            for (int i = 1; i <= number ; i++) {
                if(number % i ==0) {
                    check++;
                }
            }
            if(check == 2) {
                result += number + ", ";
            }
            number++;
            check = 0;
        }
        System.out.println("The prime numbers less than 100 are: " + result);
    }
}
