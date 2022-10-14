package exam.service.impl;

import exam.controller.TaiKhoanThanhToanController;
import exam.controller.TaiKhoanTietKiemController;
import exam.model.TaiKhoanThanhToan;
import exam.model.TaiKhoanTietKiem;
import exam.service.ITaiKhoanTietKiemService;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaiKhoanTietKiemService implements ITaiKhoanTietKiemService {

    private static Scanner scanner = new Scanner(System.in);
    private static List<TaiKhoanTietKiem> tietKiemList = new ArrayList<>();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int idTaiKhoan = 1;

    @Override
    public void add() {
        readFileTietKiem();
        TaiKhoanTietKiem taiKhoanTietKiem = this.info();
        tietKiemList.add(taiKhoanTietKiem);
        writeFileTietKiem();
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void remove() {
        readFileTietKiem();
        System.out.println("Hãy nhập mã tài khoản muốn xóa");
        String maTaiKhoan;
        maTaiKhoan = scanner.nextLine();
        for (int i = 0; i < tietKiemList.size(); i++) {
            if (tietKiemList.get(i).getMaTaiKhoan().equals(maTaiKhoan)) {
                System.out.println("Mời bạn lựa chọn");
                System.out.println("1. Yes");
                System.out.println("2.No");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        tietKiemList.remove(i);
                        writeFileTietKiem();
                        break;
                    case 2:
                        TaiKhoanTietKiemController.mainMenu();
                        break;
                }
                break;
            } else {
                System.out.println("không tìm thấy mã tài khoản đó");
            }
        }
    }

    @Override
    public void display() {
    tietKiemList = readFileTietKiem();
    for (TaiKhoanTietKiem t : tietKiemList) {
        System.out.println(t.getInfo());
    }
    }

    @Override
    public void search() {
        System.out.println("Mời bạn nhập tên tài khoản hoặc mã tài khoản");
        String search = scanner.nextLine();
        for (int i = 0; i < tietKiemList.size(); i++) {
            if (tietKiemList.get(i).getMaTaiKhoan().contains(search) || tietKiemList.get(i).getTenTaiKhoan().contains(search)) {
                System.out.println(tietKiemList.get(i));
            } else {
                System.out.println("thông tin không tồn tại");
            }
        }
    }

    public List<TaiKhoanTietKiem> readFileTietKiem() {
        tietKiemList = new ArrayList<>();
        File file = new File("src\\exam\\data\\tai_khoan_tiet_kiem.csv");
        if (!file.exists()) {
            System.out.println("File lỗi hoặc không tồn tại");
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            TaiKhoanTietKiem taiKhoanTietKiem;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                taiKhoanTietKiem = new TaiKhoanTietKiem(Integer.parseInt(info[0]), info[1], info[2], LocalDate.parse(info[3]), info[4], LocalDate.parse(info[5]), info[6], info[7]);
                tietKiemList.add(taiKhoanTietKiem);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File không có gì hãy tiếp tục chương trình");
        }
        return tietKiemList;
    }

    public void writeFileTietKiem() {
        try {
            File file = new File("src\\exam\\data\\tai_khoan_tiet_kiem.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (TaiKhoanTietKiem t : tietKiemList) {
                bufferedWriter.write(t.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public TaiKhoanTietKiem info() {
        System.out.println(" id tài khoản: " + (tietKiemList.get(tietKiemList.size()-1).getIdTaiKhoan() + 1));

        System.out.println("Mời bạn nhập mã tài khoản");
        String maTaiKhoan;
        while (true) {
            try {
                maTaiKhoan = scanner.nextLine();
                if (maTaiKhoan.matches("^[0][0][0-9]{7}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã tài khoản chưa đúng hãy nhập lại");
            }
        }
        System.out.println("Mời bạn nhập tên tài khoản");
        String tenTaiKhoan;
        while (true) {
            try {
                tenTaiKhoan = scanner.nextLine();

                if (tenTaiKhoan.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    System.out.println("Tên đúng định đạng");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tên sai định dạng. Hãy nhập lại");
            }
        }

        System.out.println("Mời bạn nhập ngày tạo tài khoản");
        LocalDate ngayTaoTaiKhoan;
        while (true) {
            try {
                ngayTaoTaiKhoan = LocalDate.parse(scanner.nextLine(), formatter);
                LocalDate date = LocalDate.now();
                long day = ngayTaoTaiKhoan.until(date, ChronoUnit.DAYS);

                if (day > 0) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ngày tạo tài khoản sai định dạng. Hãy nhập lại");
            }
        }
        System.out.println("Mời bạn nhập số tiền gửi tiết kiệm");
        String soTienGui;
        while (true) {
            try {
                soTienGui = scanner.nextLine();
                if (soTienGui.matches("^[0-9]+[0]{3}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("số tiền sai định dạng hãy nhập lại");
            }
        }
        System.out.println("Mời bạn nhập ngày gửi tiết kiệm");
        LocalDate ngayGui;
        while (true) {
            try {
                ngayGui = LocalDate.parse(scanner.nextLine(), formatter);
                long day = ngayTaoTaiKhoan.until(ngayGui, ChronoUnit.DAYS);
                if (day > 0) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ngày gửi sai định dạng hãy nhập lại");
            }
        }

        System.out.println("Nhập lãi suất");
        String laiSuat = null;
        while (true) {
            try {
                if (laiSuat.matches("^[0-9][%]$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("lãi suất sai định dạng. hãy nhập lại");
            }
        }
        System.out.println("Mời bạn nhập kì hạn");
        String kiHan = null;
        while (true) {
            try {
                if (kiHan.matches("^[1-9]+ (m|y)$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Hãy nhập lại kì hạn vì bạn đã nhập sai");
            }
        }
        TaiKhoanTietKiem taiKhoanTietKiem = new TaiKhoanTietKiem(idTaiKhoan, maTaiKhoan, tenTaiKhoan, ngayTaoTaiKhoan, soTienGui, ngayGui, laiSuat, kiHan);
        return taiKhoanTietKiem;
    }
}
