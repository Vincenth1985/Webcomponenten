package be.intecbrussel.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloWorldServlet", value = {"/helloworldservlet","/hello"})
public class HelloWorldServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");


        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>");
        writer.println("Hello World <br>");
        writer.println("Method : " + req.getMethod());

        writer.println("</h1>");

        writer.println("</body>");
        writer.println("</html>");
        writer.close();


    }

    @Override
    public void init() throws ServletException {
        System.out.println("HelloWorldServlet instantiated and initialised");
    }
}
