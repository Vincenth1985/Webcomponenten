package be.intecbrussel;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/testing")
public class RefreshNumber extends HttpServlet {


    int number = 0;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("Number",number);

        number = (Integer)req.getSession().getAttribute("Number")+1;

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(number);


    }


}
