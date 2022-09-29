package exersice.mvc.ss1_haiTT.service.impl;

public class Check extends Exception {
    public Check(String string) {
        super(string);
    }
//    public void checkName(String name)  throws Check {
//        char [] chars = name.toCharArray();
//        for (int i = 0; i < chars.length; i++){
//            if (chars[i] <= '9' && chars[i] >= '0') {
//                throw new Check("Lỗi: tên không được tồn tại ký tự số");
//            }
//        }
//    }
//    public void checkGender (String gender) throws Check {
//        if (!gender.equals("Nam") && !gender.equals("Nữ")) {
//            throw new Check("Giới tính chỉ có Nam hoặc Nữ ");
//        } else {
//            System.out.println("Giới tính đã đúng");
//        }
//    }
//    public void checkScore (double score) throws Check {
//        if (score > 10 || score < 0) {
//            throw new Check("Điểm số cần bé hơn 10 và lớn hơn 0: ");
//        } else {
//            System.out.println("Điểm đã đúng định dạng");
//        }
//    }
}
