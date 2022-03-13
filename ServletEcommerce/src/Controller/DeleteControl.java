package Controller;

import Dao.DatabaseController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteControl", urlPatterns = "/delete")
public class DeleteControl extends HttpServlet {
    DatabaseController d;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        d = new DatabaseController();
        String id = request.getParameter("pid");
        d.deleteProductByID(Integer.parseInt(id));
        getServletContext().getRequestDispatcher("/manager").forward(request,response);//load manager servlet to load all data to ManagerProduct.jsp
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
