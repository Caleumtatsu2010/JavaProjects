import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String email = request.getParameter("email");
        String firstname = request.getParameter("first");
        String lastname = request.getParameter("last");
        String age = request.getParameter("age");
        if(email == null || firstname == null || lastname == null || age == null)
        {
            request.setAttribute("error", "parameters is null");
            getServletContext().getRequestDispatcher("/index2.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("person", new Person(email, firstname, lastname, Integer.parseInt(age)));
            getServletContext().getRequestDispatcher("/index2.jsp").forward(request, response);
        }




        

    }
}
