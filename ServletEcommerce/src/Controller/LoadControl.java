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

@WebServlet(name = "LoadControl", urlPatterns = "/load")
public class LoadControl extends HttpServlet {
    DatabaseController d;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        d = new DatabaseController();
        String id = request.getParameter("pid");
        Product p = d.getDetailProduct(Integer.parseInt(id));
        request.setAttribute("detail", p);//send detail attribute which has a product to editEmployeeModal form in edit.jsp

        List<Category> listC = d.getAllCategory();
        request.setAttribute("listC", listC);//send listC attribute to editEmployeeModal form in edit.jsp

        getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
