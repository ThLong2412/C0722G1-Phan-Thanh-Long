package case_study.service.impl;

import case_study.model.Booking;
import case_study.model.Contract;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.model.person.Customer;
import case_study.service.IBookingService;
import case_study.service.ICustomerService;
import case_study.service.IFacilityService;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class BookingServiceImpl implements IBookingService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Booking> bookingList = new ArrayList<>();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Queue<Booking> bookingQueue = new LinkedList<>();
    private static List<Contract> contractList = new ArrayList<>();
    private static ICustomerService customerService = new CustomerServiceImpl();
    private static IFacilityService facilityService = new FacilityServiceImpl();

    public static List<Booking> readFileBooking() {
        bookingList = new ArrayList<>();
        File file = new File("src\\case_study\\data\\booking.csv");
        if (!file.exists()) {
            System.out.println("File không tồn tại hoặc có lỗi");
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Booking booking;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                booking = new Booking(info[0], LocalDate.parse(info[1]), LocalDate.parse(info[2]), info[3], info[4], info[5]);
                bookingList.add(booking);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return bookingList;
    }

    public void writeFileBooking() {
        try {
            File file = new File("src\\case_study\\data\\booking.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : bookingList) {
                bufferedWriter.write(booking.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }

    }

    @Override
    public void add() { // thêm mới đặt vé
        readFileBooking();
        Booking booking = this.infoBooking();
        bookingList.add(booking);
        writeFileBooking();
        System.out.println("Đã booking thành công");
    }

    public Booking infoBooking() {

        System.out.println("Mời bạn nhập mã booking");
        String codeBooking;
        while (true) {
            codeBooking = scanner.nextLine();
            try {
                if (codeBooking.matches("^[B][K][0-9]+$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã booking sai định dạng. Hãy nhập lại");
            }
        }

        System.out.println("Mời bạn nhập ngày bắt đầu");
        LocalDate dayStart;
        while (true) {

            try {
                dayStart = LocalDate.parse(scanner.nextLine(), formatter);
                LocalDate date = LocalDate.now();
                long time = date.until(dayStart, ChronoUnit.DAYS);
                if (time > 0) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ngày bắt đầu phải sau ngày hiện tại. Và phải đúng định dạng dd/MM/yyyy");
            }
        }


        System.out.println("Mời bạn nhập ngày kết thúc");
        LocalDate dayEnd;
        while (true) {

            try {
                dayEnd = LocalDate.parse(scanner.nextLine(), formatter);
                long time = dayStart.until(dayEnd, ChronoUnit.DAYS);
                if (time > 0) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ngày kết thúc phải sau ngày bắt đầu");
            }
        }

        customerService.display();
        System.out.println("Mời bạn nhập mã khách hàng");
        String codeCustomer = infoCodeCustomer();

        System.out.println("Mã dịch vụ \n 1.Mã Villa \n 2. Mã house \n 3.Mã Room \n Mời bạn lựa chọn");
        String codeService = null;
        while (true) {
            String choice;
            while (true) {
                choice = scanner.nextLine();
                try {
                    if (choice.matches("^[123]$")) {
                        break;
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Hãy chọn lại đúng với mục đã định sẵn");
                }
            }
            facilityService.display();
            System.out.println("Mời bạn nhập mã dịch vụ trương ứng");
            switch (choice) {
                case "1":
                    codeService = infoCodeVilla();
                    break;
                case "2":
                    codeService = infoCodeHouse();
                    break;
                case "3":
                    codeService = infoCodeRoom();
                    break;
                default:
                    System.out.println("Hãy lựa chọn hợp lệ với các mục đã định");
            }
            break;
        }

        System.out.println("Mời bạn nhập loại dịch vụ");
        String typeOfService;
        while (true) {
            typeOfService = scanner.nextLine();
            try {
                if (typeOfService.equals("Villa") || typeOfService.equals("House") || typeOfService.equals("Room")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tên dịch vụ không tồn tại. Hãy nhập lại");
            }
        }

        Booking booking = new Booking(codeBooking, dayStart, dayEnd, codeCustomer, codeService, typeOfService);
        return booking;
    }


    public void sortBooking() {
        Collections.sort(bookingList, new Comparator<Booking>() {
            @Override
            public int compare(Booking o1, Booking o2) {
                if (o2.getDayStart().until(o1.getDayStart(), ChronoUnit.DAYS) > 0) {
                    return 1;
                } else if (o2.getDayStart().until(o1.getDayStart(), ChronoUnit.DAYS) < 0) {
                    return -1;
                } else {
                    if (o2.getDayEnd().until(o1.getDayEnd(), ChronoUnit.DAYS) > 0) {
                        return 1;
                    } else if (o2.getDayEnd().until(o1.getDayEnd(), ChronoUnit.DAYS) < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
    }

    public String infoCodeCustomer() {
        List<Customer> list = CustomerServiceImpl.readFileCustomer();
        String codeCustomer;
        while (true) {
            codeCustomer = scanner.nextLine();
            try {
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCode().equals(codeCustomer)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã sai định dạng. hoặc không tồn tại trong danh sách khách hàng");
            }
        }
        return codeCustomer;
    }

    public String infoCodeVilla() {
        List<Villa> list = FacilityServiceImpl.readFileVilla();
        String code;
        while (true) {
            code = scanner.nextLine();
            try {
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCodeService().equals(code)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã sai định dạng. hoặc không tồn tại trong danh sách Villa");
            }
        }
        return code;
    }

    public String infoCodeHouse() {
        List<House> list = FacilityServiceImpl.readFileHouse();
        String code;
        while (true) {
            code = scanner.nextLine();
            try {
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCodeService().equals(code)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã sai định dạng. hoặc không tồn tại trong danh sách Villa");
            }
        }
        return code;
    }

    public String infoCodeRoom() {
        List<Room> list = FacilityServiceImpl.readFileRoom();
        String code;
        while (true) {
            code = scanner.nextLine();
            try {
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getCodeService().equals(code)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã sai định dạng. hoặc không tồn tại trong danh sách Villa");
            }
        }
        return code;
    }


    @Override
    public void display() {

        System.out.println("Danh sách khách hàng booking");
        bookingList = readFileBooking();
        sortBooking();
        if (bookingList.size() == 0) {
            System.out.println("chưa có danh sách booking");
        }
        for (Booking booking : bookingList) {
            System.out.println(booking);
        }
        writeFileBooking();
    }

    @Override
    public void addContract() { // làm hợp đồng
        readFileBooking();
        sortBooking();
        for (Booking booking : bookingList) {
            bookingQueue.add(booking);
        }
        int size = bookingQueue.size();
        for (int i = 0; i < size; i++) {
            System.out.println("Tạo hợp đồng cho: " + bookingQueue.peek());
            Contract contract = this.infoContract();
            contractList.add(contract);
            System.out.println("Đã tạo hợp đồng thành công");
        }
    }

    public Contract infoContract() {
        String numberContract;
        while (true) {
            System.out.println("Mời bạn nhập số hợp đồng");
            numberContract = scanner.nextLine();
            try {
                if (numberContract.matches("^[H][Đ][-][0-9]+$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Định dạng hợp đồng chưa hợp lệ");
            }
        }
        String codeBooking;
        while (true) {
            System.out.println("Mời bạn nhập mã booking");
            codeBooking = scanner.nextLine();
            try {
                boolean flag = false;
                for (int i = 0; i < bookingList.size(); i++) {
                    if (bookingList.get(i).getCodeBooking().equals(codeBooking)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã booking chưa được tạo");
            }
        }
        String advanceStack;
        while (true) {
            System.out.println("Số tiền bạn trả trước: ");
            advanceStack = scanner.nextLine();
            try {
                if (advanceStack.matches("^[1-9]*[0-9]*[0]{3}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Lỗi định dạng, hãy nhập lại");
            }
        }
        String paySum;
        while (true) {
            System.out.println("Tổng tiền thanh toán của bạn là: ");
            paySum = scanner.nextLine();
            int s1 = Integer.parseInt(advanceStack);
            int s2 = Integer.parseInt(paySum);
            try {
                if (paySum.matches("^[1-9]*[0-9]*[0]{3}$$") && s2 > s1) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Số tiền không đúng định dạng hoặc bé hơn số tiền trả trước. Hãy nhập lại");
            }
        }
        String codeCustomer;
        while (true) {
            System.out.println("Mời bạn nhập mã khách hàng");
            codeCustomer = scanner.nextLine();
            try {
                boolean flag = false;
                for (int i = 0; i < bookingList.size(); i++) {
                    if (bookingList.get(i).getCodeCustomer().equals(codeCustomer)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã khách hàng không tồn tại");
            }
        }
        Contract contract = new Contract(numberContract, codeBooking, advanceStack, paySum, codeCustomer);
        return contract;
    }

    @Override
    public void displayContract() {
        System.out.println("Danh sách hợp đồng");
        contractList = readFileContract();
        for (Contract c : contractList) {
            System.out.println(c);
        }
    }

    public List<Contract> readFileContract() {
        contractList = new ArrayList<>();
        File file = new File("src\\case_study\\data\\contract.csv");
        if (!file.exists()) {
            System.out.println("File không tồn tại hoặc có lỗi");
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Contract contract;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                contract = new Contract(info[0], info[1], info[2], info[3], info[4]);
                contractList.add(contract);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contractList;
    }

    public List<Contract> writeFileContract() {
        sortBooking();
        File file = new File("src\\case_study\\data\\contract.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Contract contract : contractList) {
                bufferedWriter.write(contract.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return contractList;
    }

    @Override
    public void editContract() {
        String codeContractEdit;
        while (true) {
            System.out.println("Mời bạn nhập số hợp đồng muốn sửa");
            codeContractEdit = scanner.nextLine();
            try {
                boolean flag = false;
                for (int i = 0; i < contractList.size(); i++) {
                    if (contractList.get(i).getNumberContract().equals(codeContractEdit)) {
                        contractList.set(i, infoContract());
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Không tìm thấy hợp đồng có số: " + codeContractEdit);
            }
        }
    }
}
