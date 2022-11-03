package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Dư Quách Trà", "2004-24-12","Quảng Trị","https://danviet.mediacdn.vn/thumb_w/650/296231569849192448/2021/5/16/12205904611537063250310157107440174689491663n-1621132980094109655024.jpeg"));
        customerList.add(new Customer("Ngọc Trinh", "2004-24-12","Quảng Trị","https://media.thieunien.vn/thumb/uploads/2021/11/23/khanh-vy-em-gai-ban-le-nu-sinh-anh-the-va-nhung-hotgirl-noi-tieng-sau-mot-dem-gio-ra-sao_49562.jpg"));
        customerList.add(new Customer("Doãn Thiên Ân", "2004-24-12","Quảng Trị","https://media.tinmoi.vn/upload/thanhdat/2021/05/13/tim-ra-info-cua-hot-girl-chup-anh-cccd-nhin-anh-ngoai-doi-con-xinh-hon-anh-tren-mang-1620917198-3.jpg"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("list_customer.jsp").forward(request, response);
    }
}
