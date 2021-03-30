package calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String principal = request.getParameter("principal");
        String interest = request.getParameter("interest");
        String year = request.getParameter("year");
        String time = request.getParameter("time");
        if(principal =="" || interest == "" || year == "" || time=="")
        {
           request.setAttribute("error", "woops, something is missing in your form");
        }
        else
        {
            double res = Calculate.calculateResults(Double.parseDouble(principal), Double.parseDouble(interest), Integer.parseInt(year), Integer.parseInt(time));
            request.setAttribute("result", res);
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
