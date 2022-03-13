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

@WebServlet(name = "LoginControl", urlPatterns = "/login")
public class LoginControl extends HttpServlet {
    DatabaseController d;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        d = new DatabaseController();
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        Account a = d.login(username, password);
        if(a==null)//user & pass ko ton tai
        {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            request.setAttribute("LoginError", "Nhập sai password hoặc username ko tồn tại");
        }
        else
        {
            HttpSession session =  request.getSession();
            session.setAttribute("acc", a);
            getServletContext().getRequestDispatcher("/homecontrol").forward(request, response);//send to homecontrol servlet to load product
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
