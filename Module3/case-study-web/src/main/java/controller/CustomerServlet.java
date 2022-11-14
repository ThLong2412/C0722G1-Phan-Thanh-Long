package controller;

import model.Customer;
import model.CustomerType;
import service.ICustomerService;
import service.ICustomerTypeService;
import service.impl.CustomerService;
import service.impl.CustomerTypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeService customerTypeService = new CustomerTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "edit":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = customerService.search(name);
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.listCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("day_of_birth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, customerTypeId, name, dayOfBirth, gender, idCard, phoneNumber, email, address);
        List<CustomerType> customerTypeList = customerTypeService.listCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        String messAdd;
        Map<String, String> checkMap = customerService.addCustomer(customer);
//        customerService.addCustomer(customer);
        if (checkMap.size() > 0) {
            messAdd = "Thêm mới không thành công";
        } else {
            messAdd = "Thêm mới thành công";
        }
        request.setAttribute("messAdd", messAdd);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return checkMap;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
//            case "delete":
//                delete(request, response);
//                break;
            case "search":
                showFormSearch(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showFormSearch(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        boolean check = customerService.delete(id);
//        String messDelete = "Xóa không thành công";
//        if (check) {
//            messDelete = "Xóa thành công";
//        }
//        request.setAttribute("messDelete", messDelete);
//        listCustomer(request, response);
//        request.getRequestDispatcher("/view_customer/list.jsp").forward(request, response);
//    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean check = customerService.delete(id);
        String messDelete = "Xóa không thành công";
        if (check) {
            messDelete = "Xóa thành công";
        }
        request.setAttribute("messDelete", messDelete);
        List<Customer> customerList = customerService.listCustomer();
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.listCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            request.getRequestDispatcher("/view_customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = customerTypeService.listCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.getCustomerById(id);
        List<CustomerType> customerTypeList = customerTypeService.listCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_customer/edit.jsp");
        request.setAttribute("customer", customer);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int customerTypeId = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String dayOfBirth = request.getParameter("day_of_birth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("id_card");
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, customerTypeId, name, dayOfBirth, gender, idCard, phoneNumber, email, address);
        String messUpdate = "Cập nhật không thành công";
        if (customerService.update(customer)) {
            messUpdate = "Cập nhật thành công";
        }
        request.setAttribute("messUpdate", messUpdate);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.listCustomer();
        request.setAttribute("customerList", customerList);
        List<CustomerType> customerTypeList = customerTypeService.listCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view_customer/list.jsp");
        dispatcher.forward(request, response);
    }
}
