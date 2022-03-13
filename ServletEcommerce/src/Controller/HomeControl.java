package Controller;

import Dao.DatabaseController;
import Objects.Category;
import Objects.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeControl", urlPatterns = "/homecontrol")
public class HomeControl extends HttpServlet
{
    DatabaseController d;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        d = new DatabaseController();
        List<Product> listP = d.getAllProduct();
        request.setAttribute("listProduct", listP);//send listP attribute to home.jsp

        List<Category> listC = d.getAllCategory();
        request.setAttribute("listCategory", listC);//send listC attribute to home.jsp
        
        Product last = d.getLastProduct();
        request.setAttribute("lastProduct", last);//send lastProduct attribute to home.jsp


        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
