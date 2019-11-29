package be.intecbrussel.servlet;

import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/square")
public class SquareServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//using lang3


        String number = req.getParameter("aNumber");
        String outputText;

        if (NumberUtils.isCreatable(number)) {
            //calculate the sqaure
            int result = NumberUtils.createInteger(number);

            outputText = "the square of " + result + " is " + (result * result);

        } else {
            //generate error messgage
            outputText = "Wrong input! you have to input a number ,no text please";

        }


        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>");
        writer.println("Here is what I have to say :");

        writer.println("</h1>");

        writer.println("<h1>");

        writer.println(outputText);

        writer.println("</h1>");

        writer.println("</body>");
        writer.println("</html>");
        writer.close();


    }
}
