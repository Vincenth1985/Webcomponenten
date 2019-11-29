package be.intecbrussel.servlet;

import be.intecbrussel.dao.GuestBookDao;
import be.intecbrussel.model.GuestbookBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/guestbook")
public class GuestbookServlet extends HttpServlet {

    private GuestBookDao guestBookDao = new GuestBookDao();


    @Override
    public void init() throws ServletException {

        guestBookDao = new GuestBookDao();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        GuestbookBean guestbookBean = new GuestbookBean(LocalDate.now(), req.getParameter("Name"), req.getParameter("Message"));
        guestBookDao.addGuestBookItem(guestbookBean);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        writer.println("<html>");
        writer.println("<head>");
        writer.println("</head>");
        writer.println("<body>");


        for (GuestbookBean guestBookItem : guestBookDao.getGuestBookItems()) {
            writer.println("<p>Date : " + guestBookItem.getDate() + " Name : " + guestBookItem.getName() + " </p>" + guestBookItem.getMessage());
        }
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 0; i < guestBookDao.getGuestBookItems().size(); i++) {
            if (guestBookDao.getGuestBookItems().get(i).getMessage().equals(req.getParameter("message"))) {
                guestBookDao.deleteGuestBookItem(guestBookDao.getGuestBookItems().get(i));
            }
        }
        PrintWriter writer = resp.getWriter();
        for (GuestbookBean guestBookItem : guestBookDao.getGuestBookItems()) {
            writer.println("<p>Date : " + guestBookItem.getDate() + " Name : " + guestBookItem.getName() + "</p> Message : " + guestBookItem.getMessage());
        }
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }
}

