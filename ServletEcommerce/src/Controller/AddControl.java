package Controller;

import Dao.DatabaseController;
import Objects.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddControl", urlPatterns = "/add")
public class AddControl extends HttpServlet {
    DatabaseController d;
     int i=7;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        d = new DatabaseController();
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));
        String title = request.getParameter("title");
        int category =Integer.parseInt(request.getParameter("category"));
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");//get isSell from account session
        String sell_id =  Integer.toString(a.getIsSell());//sell_id of product is isSell of Account
        i++;
        d.insertProduct(i, name, image, price, title, sell_id, category);
        getServletContext().getRequestDispatcher("/manager").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
