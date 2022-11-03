package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculate"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    float firstOperand = Float.parseFloat(request.getParameter("first-operand"));
    float secondOperand = Float.parseFloat(request.getParameter("second-operand"));
    char operator = request.getParameter("operator").charAt(0);
    float result =0;
    try {
         result = Calculator.calculate(firstOperand, secondOperand, operator);
    } catch (Exception e) {
        request.setAttribute("error",e.getMessage());
    }
    request.setAttribute("result", result);
    request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
