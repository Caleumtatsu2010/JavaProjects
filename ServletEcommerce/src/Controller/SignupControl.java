package Controller;

import Dao.DatabaseController;
import Objects.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

@WebServlet(name = "SignupControl", urlPatterns = "/signup")
public class SignupControl extends HttpServlet {
    DatabaseController d;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        d = new DatabaseController();
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String re_password = request.getParameter("repass");
        if(re_password.equals(password)==false)//password va re_password ko trung nhau
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            if(d.checkUser(username) == false)//username ko ton tai trong database=> dc signup
            {
                d.signup(username, password);
                getServletContext().getRequestDispatcher("/homecontrol").forward(request, response);
            }
            else
            {
                response.sendRedirect("login.jsp");
                request.setAttribute("SignupError", "username đã tồn tại");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
