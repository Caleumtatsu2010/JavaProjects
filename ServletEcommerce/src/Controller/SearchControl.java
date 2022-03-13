package Controller;

import Dao.DatabaseController;
import Objects.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchControl", urlPatterns = "/search")
public class SearchControl extends HttpServlet {
    DatabaseController d;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        d = new DatabaseController();
        request.setCharacterEncoding("UTF-8");
        String txtSearch = request.getParameter("txt");//get value of input has name of txt from form in menu.jsp
        List<Product> searchProduct = d.getAllProductByName(txtSearch);
        request.setAttribute("listProduct", searchProduct);//send searchProduct replace listProduct in home.jsp

        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
