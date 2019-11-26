package be.intecbrussel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/numberservlet")
public class NumberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Random randomNumberGenerator = new Random();
        int randomNumber = randomNumberGenerator.nextInt(10) + 1;
        PrintWriter writer = resp.getWriter();
        writer.println(randomNumber);


    }


}
