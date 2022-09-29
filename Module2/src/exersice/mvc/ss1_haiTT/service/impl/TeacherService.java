package exersice.mvc.ss1_haiTT.service.impl;

import exersice.mvc.ss1_haiTT.service.ITeacherService;
import exersice.mvc.ss1_haiTT.model.Teacher;
import ss15_exception_and_debug.exersice.TriangleEdgesCheck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    public void addTeacher() {
        Teacher teacher = this.displayTeacher();
        teacherList.add(teacher);
        System.out.println("Da them moi giang vien thanh cong");
    }

    public Teacher displayTeacher() {
        System.out.println("nhap ma giang vien");
        String code = scanner.nextLine();
        String name;
        while (true) {
            System.out.println("nhap ten giang vien");
            name = scanner.nextLine();
            try {
                checkName(name);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("nhap ngay sinh giang vien");
        String pattern = scanner.nextLine();
        String gender;
        while (true) {
            System.out.println("nhap gioi tinh giang vien");
            gender = scanner.nextLine();
            try {
                checkGender(gender);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("nhap chuyen mon giang vien");
        String specializes = scanner.nextLine();
        Teacher teacher = new Teacher(code, name, pattern, gender, specializes);
        return teacher;
    }

    public void displayAllTeacher() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public void removeTeacher() {
        System.out.println("nhap ma GV can xoa");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa GV này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    teacherList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
        }
    }

    public void findTeacher() {
        System.out.println("1. tìm kiếm theo tên giảng viên");
        System.out.println("2. tìm kiếm theo mã giảng viên");
        System.out.println("mời bạn lựa chọn");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println("nhập tên giảng viên muốn tìm");
                String nameFind = scanner.nextLine();

                boolean flag = false;
                for (int i = 0; i < teacherList.size(); i++) {
                    if (teacherList.get(i).getName().contains(nameFind)) {
                        System.out.println(teacherList.get(i));
                        flag = true;
                        break;
                    }
                    if (!flag) {
                        System.out.println("không tìm thấy giảng viên");
                    }
                }
                break;
            case 2:
                System.out.println("nhập mã giảng viên muốn tìm");
                String codeFind = scanner.nextLine();

                boolean flag2 = false;
                for (int i = 0; i < teacherList.size(); i++) {
                    if (teacherList.get(i).getCode().equals(codeFind)) {
                        System.out.println(teacherList.get(i));
                        flag2 = true;
                        break;
                    }
                    if (!flag2) {
                        System.out.println("không tìm thấy giảng viên");
                    }
                }
                break;
        }
    }
    public void sortTeacher(){
        if (teacherList.size() <=0) {
            System.out.println("Không có danh sách để sắp xếp");
            return;
        }
        boolean isSwap = true;
        for (int i = 0; i < teacherList.size() -1; i++) {
            isSwap = false;
            for (int j = i + 1; j < teacherList.size() - i -1; j++) {
                if (teacherList.get(j).compareTo(teacherList.get(j+1) ) > 0) {
                    isSwap = true;
                    Teacher temp = teacherList.get(j+1);
                    teacherList.set(j+1, teacherList.get(j));
                    teacherList.set(j, temp);
                }

            }

        }
        System.out.println("Đã sắp xếp thành công \n Danh sách sau khi sắp xếp là: ");
    }

    @Override
    public void readTeacher() throws IOException {
        File file = new File("src\\exersice\\mvc\\ss1_haiTT\\data\\teacherread.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        List<Teacher> teachers = new ArrayList<>();
        String line;
        String[] info;
        Teacher teacher;
        while ((line = bufferedReader.readLine()) != null) {
            info = line.split(",");
            teacher = new Teacher(info[0],info[1],info[2],info[3],info[4]);
            teachers.add(teacher);
        }
        bufferedReader.close();

        for (Teacher t : teachers) {
            System.out.println(t.getInfo());
        }
    }

    @Override
    public void writeTeacher() throws IOException {
    File file = new File("src\\exersice\\mvc\\ss1_haiTT\\data\\teacherwrite.csv");
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < teacherList.size(); i++) {
            bufferedWriter.write(String.valueOf(teacherList.get(i).getInfo()));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        System.out.println("Đã ghi giảng viên thành công");
    }

    public void checkName(String name)  throws Check {
        char [] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (chars[i] <= '9' && chars[i] >= '0') {
                throw new Check("Lỗi: tên không được tồn tại ký tự số");
            }
        }
    }
    public void checkGender (String gender) throws Check {
        if (!gender.equals("Nam") && !gender.equals("Nữ")) {
            throw new Check("Giới tính chỉ có Nam hoặc Nữ ");
        } else {
            System.out.println("Giới tính đã đúng");
        }
    }
    public void checkScore (double score) throws Check {
        if (score > 10 || score < 0) {
            throw new Check("Điểm số cần bé hơn 10 và lớn hơn 0: ");
        } else {
            System.out.println("Điểm đã đúng định dạng");
        }
    }
}
