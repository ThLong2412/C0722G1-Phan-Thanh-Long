package case_study.service.impl;


import case_study.controller.FuramaController;
import case_study.model.Booking;
import case_study.model.facility.Facility;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.service.IBookingService;
import case_study.service.IFacilityService;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FacilityServiceImpl implements IFacilityService {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Villa> villaList = new ArrayList<>();
    private static List<House> houseList = new ArrayList<>();
    private static List<Room> roomList = new ArrayList<>();
    private static Map<Facility, Integer> facilityList = new LinkedHashMap<>();
    private static List<Facility> list = new ArrayList<>();
    private static IBookingService bookingService = new BookingServiceImpl();
    private static List<Facility> maintenanceMap = new ArrayList<>();

    @Override
    public void maintenanceDisplay() {
        facilityList = new LinkedHashMap<>();
        List<Booking> bookingList = readFileBookingFromList();
        for (Villa villa : villaList) {
            facilityList.put(villa, 0);
        }
        for (House house : houseList) {
            facilityList.put(house, 0);
        }
        for (Room room : roomList) {
            facilityList.put(room, 0);
        }
        for (int i = 0; i < bookingList.size(); i++) {
            for (Facility key : facilityList.keySet()) {
                if (bookingList.get(i).getCodeService().equals(key.getCodeService())) {
                    facilityList.replace(key, facilityList.get(key) + 1);
                    if (facilityList.get(key) >= 5) {
                        maintenanceMap.add(key);
                    }
                    writeFileMaintenance();
                    if (key instanceof Villa) {
                        for (int j = 0; j < villaList.size(); j++) {
                            if (villaList.get(j).equals(key)) {
                                villaList.remove(j);
                            }
                        }
                    } else if (key instanceof  House) {
                        for (int j = 0; j < houseList.size(); j++) {
                            if (houseList.get(j).equals(key)) {
                                houseList.remove(j);
                            }
                        }
                    } else {
                        for (int j = 0; j < roomList.size(); j++) {
                            if (roomList.get(j).equals(key)) {
                                roomList.remove(j);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("danh sách cơ sở bảo trì là");
        for (Facility facility: maintenanceMap) {
            System.out.println(facility);
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

    public void writeFileMaintenance() {
        try {
            File file = new File("src\\case_study\\data\\maintenance.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Facility facility : maintenanceMap) {
                bufferedWriter.write(String.valueOf(facility));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void add() {
        while (true) {
            System.out.println("Mời bạn chọn cơ sở muốn thêm  \n 1. Thêm mới Villa \n 2. Thêm mới House \n 3. Thêm mới Room \n 4. Trở về menu");
            System.out.println("Mời bạn lựa chọn");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            switch (choiceAdd) {
                case 1:
                    readFileVilla();
                    Villa villa = this.infoVilla();
                    villaList.add(villa);
                    System.out.println("thêm mới villa thành công");
                    writeFileVilla();
                    facilityList.put(villa, 0);
                    break;
                case 2:
                    readFileHouse();
                    House house = this.infoHouse();
                    houseList.add(house);
                    System.out.println("thêm mới house thành công");
                    writeFileHouse();
                    facilityList.put(house, 0);
                    break;
                case 3:
                    readFileRoom();
                    Room room = this.infoRoom();
                    roomList.add(room);
                    System.out.println("Thêm mới room thành công");
                    writeFileRoom();
                    facilityList.put(room, 0);
                    break;
                case 4:
                    FuramaController.displayMainMenu();
                    break;
                default:
                    System.out.println("Hãy lựa chọn đúng với các thao tác đã định");
                    return;
            }
        }
    }


    @Override
    public void display() {
        System.out.println("Danh sách Villa");
        villaList = readFileVilla();
        for (Villa villa : villaList) {
            System.out.println(villa);
        }
        System.out.println("Danh sách House");
        houseList = readFileHouse();
        for (House house : houseList) {
            System.out.println(house);
        }
        System.out.println("Danh sách Room");
        roomList = readFileRoom();
        for (Room room : roomList) {
            System.out.println(room);
        }
    }


    public Villa infoVilla() {
        System.out.println("Mời bạn nhập tên Villa");
        String name;
        while (true) {
            name = scanner.nextLine();
            try {
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    System.out.println("Tên đúng định đạng");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tên sai định dạng. Hãy nhập lại");
            }
        }

        System.out.println("Mời bạn nhập mã dịch vụ");
        String codeService;
        while (true) {
            codeService = scanner.nextLine();
            try {
                if (codeService.matches("[S][V][V][L][-][0-9]{4}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("định dạng mã dịch vụ sai. hãy nhập lại");
            }
        }
        System.out.println("Nhập diện tích sử dụng");
        String usableArea;
        while (true) {
            usableArea = scanner.nextLine();
            try {
                if (usableArea.matches("^[3-9][0-9][m][2]$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        System.out.println("Mời bạn nhập chi phí");
        String cost;
        while (true) {
            cost = scanner.nextLine();
            try {
                if (cost.matches("^[1-9][0-9]+[0]{3}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }

        int maxNumberOfPeople;
        while (true) {
            System.out.println("mời bạn nhập số người tối đa");
            maxNumberOfPeople = Integer.parseInt(scanner.nextLine());
            try {
                if (maxNumberOfPeople > 0 && maxNumberOfPeople < 20) {
                    System.out.println("số người hợp lệ");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (NumberFormatException e) {
                System.out.println("số người phải là số");
            } catch (Exception e) {
                System.out.println("Số người không hợp lệ, hãy nhập lại");
            }
        }
        System.out.println("Mời bạn nhập kiểu thuê (theo giờ, ngày, tháng, năm)");
        String time;
        while (true) {
            time = scanner.nextLine();
            try {
                if (time.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        System.out.println("Mời bạn nhập tiêu chuẩn Villa");
        String villaStandard;
        while (true) {
            villaStandard = scanner.nextLine();
            try {
                if (villaStandard.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        System.out.println("Mời bạn nhập diện tích bể bơi");
        String pollArea;
        while (true) {
            pollArea = scanner.nextLine();
            try {
                if (pollArea.matches("^[3-9][0-9][m][2]$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }

        int numberRoom;
        while (true) {
            System.out.println("mời bạn nhập số tầng");
            numberRoom = Integer.parseInt(scanner.nextLine());
            try {
                if (numberRoom > 0) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (NumberFormatException e) {
                System.out.println("Số tầng phải là một số");
            } catch (Exception e) {
                System.out.println("số tầng phải là số dương");
            }
        }

        Villa villa = new Villa(name, codeService, usableArea, cost, maxNumberOfPeople, time, villaStandard, pollArea, numberRoom);
        return villa;
    }

    public House infoHouse() {
        System.out.println("Mời bạn nhập tên House");
        String name;
        while (true) {
            name = scanner.nextLine();
            try {
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    System.out.println("Tên đúng định đạng");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tên sai định dạng. Hãy nhập lại");
            }
        }

        System.out.println("Mời bạn nhập mã dịch vụ");
        String codeService;
        while (true) {
            codeService = scanner.nextLine();
            try {
                if (codeService.matches("[S][V][H][O][-][0-9]{4}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("định dạng mã dịch vụ sai. hãy nhập lại");
            }
        }

        System.out.println("Nhập diện tích sử dụng");
        String usableArea;
        while (true) {
            usableArea = scanner.nextLine();
            try {
                if (usableArea.matches("^[3-9][0-9][m][2]$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        System.out.println("Mời bạn nhập chi phí");
        String cost;
        while (true) {
            cost = scanner.nextLine();
            try {
                if (cost.matches("^[1-9][0-9]+[0]{3}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }

        int maxNumberOfPeople;
        while (true) {
            System.out.println("mời bạn nhập số người tối đa");
            maxNumberOfPeople = Integer.parseInt(scanner.nextLine());
            try {
                if (maxNumberOfPeople > 0 && maxNumberOfPeople < 20) {
                    System.out.println("số người hợp lệ");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (NumberFormatException e) {
                System.out.println("Số người phải là một số");
            } catch (Exception e) {
                System.out.println("Số người không hợp lệ, hãy nhập lại");
            }
        }
        System.out.println("Mời bạn nhập kiểu thuê (theo giờ, ngày, tháng, năm)");
        String time;
        while (true) {
            time = scanner.nextLine();
            try {
                if (time.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        System.out.println("Mời bạn nhập tiêu chuẩn House");
        String houseStandard;
        while (true) {
            houseStandard = scanner.nextLine();
            try {
                if (houseStandard.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        int numberFloor;
        while (true) {
            System.out.println("mời bạn nhập số tầng");
            numberFloor = Integer.parseInt(scanner.nextLine());
            try {
                if (numberFloor > 0) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (NumberFormatException e) {
                System.out.println("Số tầng phải là một số");
            } catch (Exception e) {
                System.out.println("số tầng phải là số dương");
            }
        }
        House house = new House(name, codeService, usableArea, cost, maxNumberOfPeople, time, houseStandard, numberFloor);
        return house;
    }

    public Room infoRoom() {
        System.out.println("Mời bạn nhập tên Room");
        String name;
        while (true) {
            name = scanner.nextLine();
            try {
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    System.out.println("Tên đúng định đạng");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tên sai định dạng. Hãy nhập lại");
            }
        }

        System.out.println("Mời bạn nhập mã dịch vụ");
        String codeService;
        while (true) {
            codeService = scanner.nextLine();
            try {
                if (codeService.matches("[S][V][R][O][-][0-9]{4}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("định dạng mã dịch vụ sai. hãy nhập lại");
            }
        }

        System.out.println("Nhập diện tích sử dụng");
        String usableArea;
        while (true) {
            usableArea = scanner.nextLine();
            try {
                if (usableArea.matches("^[3-9][0-9][m][2]$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        System.out.println("Mời bạn nhập chi phí");
        String cost;
        while (true) {
            cost = scanner.nextLine();
            try {
                if (cost.matches("^[1-9][0-9]+[0]{3}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        int maxNumberOfPeople;
        while (true) {
            System.out.println("mời bạn nhập số người tối đa");
            maxNumberOfPeople = Integer.parseInt(scanner.nextLine());
            try {
                if (maxNumberOfPeople > 0 && maxNumberOfPeople < 20) {
                    System.out.println("số người hợp lệ");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Số người không hợp lệ, hãy nhập lại");
            }
        }

        System.out.println("Mời bạn nhập kiểu thuê (theo giờ, ngày, tháng, năm)");
        String time;
        while (true) {
            time = scanner.nextLine();
            try {
                if (time.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng, vui lòng nhập lại");
            }
        }
        System.out.println("mời bạn nhập dịch vụ miễn phí đi kèm");
        String freeServiceIncluded;
        while (true) {
            freeServiceIncluded = scanner.nextLine();
            try {
                if (freeServiceIncluded.equals("Có") || freeServiceIncluded.equals("Không")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Định dạng sai. Hãy nhập lại");
            }
        }
        Room room = new Room(name, codeService, usableArea, cost, maxNumberOfPeople, time, freeServiceIncluded);
        return room;
    }

    public static List<Villa> readFileVilla() {
        villaList = new ArrayList<>();
        try {
            File file = new File("src\\case_study\\data\\villa.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Villa villa;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                villa = new Villa(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), info[5], info[6], info[7], Integer.parseInt(info[8]));
                villaList.add(villa);
            }
            bufferedReader.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.getMessage();
        }
        return villaList;
    }

    public static List<House> readFileHouse() {
        houseList = new ArrayList<>();
        try {
            File file = new File("src\\case_study\\data\\house.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            House house;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                house = new House(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7]));
                houseList.add(house);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return houseList;
    }

    public static List<Room> readFileRoom() {
        roomList = new ArrayList<>();
        try {
            File file = new File("src\\case_study\\data\\room.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Room room;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                room = new Room(info[0], info[1], info[2], info[3], Integer.parseInt(info[4]), info[5], info[6]);
                roomList.add(room);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return roomList;
    }

    public static void writeFileVilla() {
        try {
            File file = new File("src\\case_study\\data\\villa.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Villa villa : villaList) {
                bufferedWriter.write(villa.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void writeFileHouse() {
        try {
            File file = new File("src\\case_study\\data\\house.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (House house : houseList) {
                bufferedWriter.write(house.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void writeFileRoom() {
        try {
            File file = new File("src\\case_study\\data\\room.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Room room : roomList) {
                bufferedWriter.write(room.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}




