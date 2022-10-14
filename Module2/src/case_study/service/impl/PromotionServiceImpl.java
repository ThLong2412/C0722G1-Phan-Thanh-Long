package case_study.service.impl;

import case_study.model.Booking;
import case_study.service.IBookingService;
import case_study.service.IPromotionService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class PromotionServiceImpl implements IPromotionService {
    private Scanner scanner = new Scanner(System.in);
    private static IBookingService bookingService = new BookingServiceImpl();
    private static Stack<Booking> stack = new Stack<>();

    @Override
    public void displayCustomerUsingService() {
        List<Booking> list = readFileBookingFromList();
        for (Booking b : list) {
            System.out.println("Khách hàng đang sử dụng dịch vụ có mã: " + b.getCodeCustomer() + "  và sẽ trà lại dịch vụ vào ngày: " + b.getDayEnd());
        }
    }

    @Override
    public void displayCustomerVoucher() {
        System.out.println("Nhập số lượng voucher 50%");
        int amount50 = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập số lượng voucher 20%");
        int amount20 = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập số lượng voucher 10%");
        int amount10 = Integer.parseInt(scanner.nextLine());

        int size = amount10 + amount20 + amount50;
        Stack<String> stackVoucher = new Stack<>();

        for (int i = 0; i < amount50; i++) {
            stackVoucher.push("50%");
        }
        for (int i = amount50; i < amount50 + amount20; i++) {
            stackVoucher.push("20%");
        }
        for (int i = amount50 + amount20; i < size; i++) {
            stackVoucher.push("10%");
        }
        List<Booking> bookingList = readFileBookingFromList();

        LocalDate firstDay = getCurrentMonthFirstDate();
        LocalDate lastDay = getCurrentMonthLastDate();

        for (Booking booking : bookingList) {
            if (firstDay.until(booking.getDayStart(), ChronoUnit.DAYS) > 0 && (booking.getDayStart()).until(lastDay, ChronoUnit.DAYS) > 0) {
                stack.push(booking);
            }
        }
        int sizeStack = stack.size();
        if (stack.size() == stackVoucher.size()) {
            for (int j = 0; j < sizeStack; j++) {
                System.out.println("Khách hàng có mã: " + stack.peek().getCodeBooking() + " nhận được voucher giảm giá: " + stackVoucher.pop() + "(Ngày booking: " + stack.pop().getDayStart() +")");
            }
        } else {
            System.out.println("số lượng khách hàng trong tháng chưa đủ để thực hiên tặng voucher");
        }
    }

    public List<Booking> readFileBookingFromList() {
        List<Booking> list = new ArrayList<>();
        try {
            File file = new File("src\\case_study\\data\\booking.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Booking booking;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                booking = new Booking(info[0], LocalDate.parse(info[1]), LocalDate.parse(info[2]), info[3], info[4], info[5]);
                list.add(booking);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return list;
    }

    public static LocalDate getCurrentMonthFirstDate() {
        return LocalDate.ofEpochDay(System.currentTimeMillis() / (24 * 60 * 60 * 1000)).withDayOfMonth(1);
    }

    public static LocalDate getCurrentMonthLastDate() {
        return LocalDate.ofEpochDay(System.currentTimeMillis() / (24 * 60 * 60 * 1000)).plusMonths(1).withDayOfMonth(1).minusDays(1);
    }

}
