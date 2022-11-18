package controller;

import model.BenhAn;
import model.BenhNhan;
import repository.IBenhNhanRepository;
import service.IBenhAnService;
import service.IBenhNhanService;
import service.impl.BenhAnService;
import service.impl.BenhNhanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BenhAnServlet", urlPatterns = {"/benhan"})
public class BenhAnServlet extends HttpServlet {
    private IBenhAnService benhAnService = new BenhAnService();
    private IBenhNhanService benhNhanService = new BenhNhanService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "edit":
                break;
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                break;
            case "delete":
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAn> benhAnList = benhAnService.showList();
        request.setAttribute("benhAnList",benhAnList);

        List<BenhNhan> benhNhanList = benhNhanService.showList();
        request.setAttribute("benhNhanList",benhNhanList);
        RequestDispatcher dispatcher =request.getRequestDispatcher("/view/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
