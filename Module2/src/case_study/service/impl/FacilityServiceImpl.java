package case_study.service.impl;


import case_study.controller.FuramaController;
import case_study.model.facility.House;
import case_study.model.facility.Room;
import case_study.model.facility.Villa;
import case_study.service.IFacilityService;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FacilityServiceImpl implements IFacilityService {

    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Integer> map = new LinkedHashMap<>();
    private static List<Villa> villaList = new ArrayList<>();
    private static List<House> houseList = new ArrayList<>();
    private static List<Room> roomList = new ArrayList<>();

    @Override
    public void maintenanceDisplay() {

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
                    break;
                case 2:
                    readFileHouse();
                    House house = this.infoHouse();
                    houseList.add(house);
                    System.out.println("thêm mới house thành công");
                    writeFileHouse();
                    break;
                case 3:
                    readFileRoom();
                    Room room = this.infoRoom();
                    roomList.add(room);
                    System.out.println("Thêm mới room thành công");
                    writeFileRoom();
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
        readFileVilla();
        System.out.println("Danh sách Villa");
        for (Villa villa : villaList) {
            System.out.println(villa);
        }
        readFileHouse();
        System.out.println("Danh sách House");
        for(House house : houseList) {
            System.out.println(house);
        }
        readFileRoom();
        System.out.println("Danh sách Room");
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
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
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
            } catch (Exception e) {
                System.out.println("Số người không hợp lệ, hãy nhập lại");
            }
        }
        System.out.println("Mời bạn nhập kiểu thuê (theo giờ, ngày, tháng, năm)");
        String time;
        while (true) {
            time = scanner.nextLine();
            try {
                if (time.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
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
                if (villaStandard.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
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
                } else  {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("số tầng phải là số dương");
            }
        }

        Villa villa = new Villa(name,codeService, usableArea, cost, maxNumberOfPeople, time, villaStandard, pollArea, numberRoom);
        return villa;
    }

    public House infoHouse() {
        System.out.println("Mời bạn nhập tên House");
        String name;
        while (true) {
            name = scanner.nextLine();
            try {
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
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
            } catch (Exception e) {
                System.out.println("Số người không hợp lệ, hãy nhập lại");
            }
        }
        System.out.println("Mời bạn nhập kiểu thuê (theo giờ, ngày, tháng, năm)");
        String time;
        while (true) {
            time = scanner.nextLine();
            try {
                if (time.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
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
                if (houseStandard.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
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
                } else  {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("số tầng phải là số dương");
            }
        }
        House house = new House(name,codeService, usableArea, cost, maxNumberOfPeople, time, houseStandard, numberFloor);
        return house;
    }

    public Room infoRoom() {
        System.out.println("Mời bạn nhập tên House");
        String name;
        while (true) {
            name = scanner.nextLine();
            try {
                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
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
                if (time.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
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

    public static void readFileVilla() {
        try {
            File file = new File("src\\case_study\\data\\villa.csv");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            villaList = (List<Villa>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
    }
    public static void readFileHouse() {
        try {
            File file = new File("src\\case_study\\data\\house.csv");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            villaList = (List<Villa>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
    }
    public static void readFileRoom() {
        try {
            File file = new File("src\\case_study\\data\\room.csv");
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            villaList = (List<Villa>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
    }
    public static void writeFileVilla() {
        try {
            File file = new File("src\\case_study\\data\\villa.csv");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(villaList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public static void writeFileHouse() {
        try {
            File file = new File("src\\case_study\\data\\house.csv");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(houseList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
    public static void writeFileRoom() {
        try {
            File file = new File("src\\case_study\\data\\room.csv");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(roomList);
            objectOutputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }
}




