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

@WebServlet(name = "DetailControl", urlPatterns = "/detail")
public class DetailControl extends HttpServlet
{
    DatabaseController d;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String id = request.getParameter("pid");
        d = new DatabaseController();
        Product p = d.getDetailProduct(Integer.parseInt(id));
        request.setAttribute("detail", p);//send detail product to detail.jsp

        List<Category> listC = d.getAllCategory();
        request.setAttribute("listC", listC);//send listCategory to detail.jsp

        Product last = d.getLastProduct();
        request.setAttribute("p", last);//send lastProduct to detail.jsp

        getServletContext().getRequestDispatcher("/detail.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
