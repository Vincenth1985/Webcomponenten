package be.intecbrussel.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       //getparameter is wat een klant geeft.

        String echoText = req.getParameter("echoText");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>");
        writer.println("Here is what i have to say :");

        writer.println("</h1>");

        writer.println("<h1>");
        writer.println(echoText.toUpperCase());

        writer.println("</h1>");

        writer.println("</body>");
        writer.println("</html>");
        writer.close();



    }
}
