import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ErrorExampleServlet", urlPatterns = "/exception")
public class ErrorExampleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String account =  getServletContext().getInitParameter("account");
//        String opinion = getServletConfig().getInitParameter("opinion");
//        System.out.println(account);
//        System.out.println(opinion);
        getServletContext().getRequestDispatcher("/index3.jsp").forward(request, response);

    }
}
