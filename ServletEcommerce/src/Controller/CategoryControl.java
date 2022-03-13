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

@WebServlet(name = "CategoryControl", urlPatterns = "/category")
public class CategoryControl extends HttpServlet
{
    DatabaseController d;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categorcid = request.getParameter("cid");
        d = new DatabaseController();
        List<Product> list = d.getAllProductByCategory(Integer.parseInt(categorcid));
        request.setAttribute("listProduct", list);//replace old listProduct in home.jsp
        List<Category> listC = d.getAllCategory();
        request.setAttribute("listCategory", listC);//replace old listCategory in home.jsp

        Product last = d.getLastProduct();
        request.setAttribute("lastProduct", last);//replace old lastProduct attribute in home.jsp

        request.setAttribute("tag", categorcid);

        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
