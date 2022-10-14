package exam.service.impl;

import exam.controller.TaiKhoanThanhToanController;
import exam.model.TaiKhoanThanhToan;
import exam.service.ITaiKhoanThanhToanService;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaiKhoanThanhToanService implements ITaiKhoanThanhToanService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<TaiKhoanThanhToan> thanhToanList = new ArrayList<>();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private int idTaiKhoan = 1;

    @Override
    public void add() {
        readFileThanhToan();
        TaiKhoanThanhToan taiKhoanThanhToan = this.info();
        thanhToanList.add(taiKhoanThanhToan);
        writeFileThanhToan();
        System.out.println("Thêm mới tài khoản thanh toán thành công");
    }

    @Override
    public void remove() {
        readFileThanhToan();
        System.out.println("Hãy nhập mã tài khoản muốn xóa");
        String maTaiKhoan;
        maTaiKhoan = scanner.nextLine();
        for (int i = 0; i < thanhToanList.size(); i++) {
            if (thanhToanList.get(i).getMaTaiKhoan().equals(maTaiKhoan)) {
                System.out.println("Mời bạn lựa chọn");
                System.out.println("1. Yes");
                System.out.println("2.No");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        thanhToanList.remove(i);
                        writeFileThanhToan();
                        break;
                    case 2:
                        TaiKhoanThanhToanController.mainMenu();
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
    thanhToanList = readFileThanhToan();
    for (TaiKhoanThanhToan t : thanhToanList) {
        System.out.println(t);
        if (thanhToanList.size() == 0 ) {
            break;
        }
    }
    }

    @Override
    public void search() {
        System.out.println("Mời bạn nhập tên tài khoản hoặc mã tài khoản");
        String search = scanner.nextLine();
        for (int i = 0; i < thanhToanList.size(); i++) {
            if (thanhToanList.get(i).getMaTaiKhoan().contains(search) || thanhToanList.get(i).getTenTaiKhoan().contains(search)) {
                System.out.println(thanhToanList.get(i));
            } else {
                System.out.println("thông tin không tồn tại");
            }
        }
    }

    public List<TaiKhoanThanhToan> readFileThanhToan() {
        thanhToanList = new ArrayList<>();
        File file = new File("src\\exam\\data\\tai_khoan_thanh_toan.csv");
        if (!file.exists()) {
            System.out.println("File lỗi hoặc không tồn tại");
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            TaiKhoanThanhToan taiKhoanThanhToan;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                taiKhoanThanhToan = new TaiKhoanThanhToan(Integer.parseInt(info[0]), info[1],info[2], LocalDate.parse(info[3]), info[4], info[5]);
                thanhToanList.add(taiKhoanThanhToan);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File không có gì hãy tiếp tục chương trình");
        }
      return thanhToanList;
    }
    public void writeFileThanhToan() {
        try {
            File file = new File("src\\exam\\data\\tai_khoan_thanh_toan.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (TaiKhoanThanhToan t : thanhToanList) {
                bufferedWriter.write(t.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();



            
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public TaiKhoanThanhToan info() {
        System.out.println(" id tài khoản: " + (thanhToanList.get(thanhToanList.size()-1).getIdTaiKhoan() + 1));

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

            try { ngayTaoTaiKhoan = LocalDate.parse(scanner.nextLine(), formatter);
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

        System.out.println("Mời bạn nhập số thẻ");
        String soThe;
        while (true) {
            try {
                soThe = scanner.nextLine();
                if (soThe.matches("^[0-9]+$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Số thẻ sai định dạng. Hãy nhập lại");
            }
        }

        System.out.println("Mời bạn nhập số tiền trong tài khoản");
        String soTienTrongTaiKhoan;
        while (true) {
            try {
                soTienTrongTaiKhoan = scanner.nextLine();
                if (soTienTrongTaiKhoan.matches("^[0-9]+[0]{3}$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Số tiền sai định dạng hãy nhập lại");
            }
        }

        TaiKhoanThanhToan taiKhoanThanhToan = new TaiKhoanThanhToan(idTaiKhoan, maTaiKhoan, tenTaiKhoan, ngayTaoTaiKhoan, soThe, soTienTrongTaiKhoan);
        return taiKhoanThanhToan;
    }
}
