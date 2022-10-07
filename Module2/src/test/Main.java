package test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;

import static java.util.concurrent.TimeUnit.DAYS;

public class Main {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
   private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        System.out.println("nhập ngày sinh");
//        LocalDate localDate = LocalDate.parse(scanner.nextLine(),formatter);
//        LocalDate date = LocalDate.now();
//        long day = localDate.until(date, ChronoUnit.DAYS);
//        System.out.println(day);
        System.out.println(getCurrentMonthFirstDate());
        System.out.println(getCurrentMonthLastDate());

    }
    public static LocalDate getCurrentMonthFirstDate() {
        return LocalDate.ofEpochDay(System.currentTimeMillis() / (24 * 60 * 60 * 1000) ).withDayOfMonth(1);
    }

    public static LocalDate getCurrentMonthLastDate() {
        return LocalDate.ofEpochDay(System.currentTimeMillis() / (24 * 60 * 60 * 1000) ).plusMonths(1).withDayOfMonth(1).minusDays(1);
    }
}
