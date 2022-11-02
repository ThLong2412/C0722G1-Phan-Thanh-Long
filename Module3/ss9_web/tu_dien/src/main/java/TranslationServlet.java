import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslationServlet", value = {"/translate"})
public class TranslationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map <String, String> dictionary = new HashMap<>();
        dictionary.put("banana", "Quả chuối");
        dictionary.put("book", "Sách");
        dictionary.put("school", "Trường học");
        dictionary.put("employee", "Nhân viên");
        String search = request.getParameter("txtSearch");
        PrintWriter printWriter = response.getWriter();
        String result = dictionary.get(search);
        printWriter.write("<html>");
        if (search != null) {
            printWriter.write("Word: " + search + "<br>");
            printWriter.write("Result: " + result);
        } else {
            printWriter.write("Not found");
        }
        printWriter.write("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
