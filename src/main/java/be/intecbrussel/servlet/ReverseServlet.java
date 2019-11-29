package be.intecbrussel.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reverse")
public class ReverseServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String text = req.getParameter("text2");
        StringBuilder stringBuilder = new StringBuilder(text);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>");
        writer.println("Here is what I have to say :");

        writer.println("</h1>");

        writer.println("<h1>");
        if (stringBuilder.toString().equals("bonjour")) {

            writer.println("Easter Egg");

        } else {
            writer.println(stringBuilder.reverse().toString());
        }

        writer.println("</h1>");

        writer.println("</body>");
        writer.println("</html>");
        writer.close();


    }
}
