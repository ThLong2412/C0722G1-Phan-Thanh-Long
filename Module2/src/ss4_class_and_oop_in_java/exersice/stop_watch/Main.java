package ss4_class_and_oop_in_java.exersice.stop_watch;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StopWatch stopWatch = new StopWatch();
        System.out.println("1. startTime.");
        System.out.println("2. endTime.");
        System.out.println("3. pastTime.");
        for (int i = 0; i < 3 ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 1) {
                System.out.println("Your start time is a: " + stopWatch.start() + " milliseconds");
            }if (number == 2) {
                System.out.println("Your end time is a: " + stopWatch.stop() + " milliseconds");
            }if (number == 3) {
                System.out.println("Your past time is a: " + stopWatch.getElapsedTime() + " milliseconds");
            }
        }
    }
}
