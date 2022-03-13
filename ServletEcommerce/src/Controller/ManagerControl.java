package Controller;

import Dao.DatabaseController;
import Objects.Account;
import Objects.Category;
import Objects.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerControl", urlPatterns = "/manager")
public class ManagerControl extends HttpServlet
{
    DatabaseController d;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        d = new DatabaseController();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");//get isSell from an account from session "acc"

        List<Product> list = d.getAllProductBySell(a.getIsSell());
        request.setAttribute("listP", list);

        List<Category> listC = d.getAllCategory();
        request.setAttribute("listC", listC);//send listC attribute to addEmployeeModal form in ManagerProduct.jsp

        getServletContext().getRequestDispatcher("/ManagerProduct.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
