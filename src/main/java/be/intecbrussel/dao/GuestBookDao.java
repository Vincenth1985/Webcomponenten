package be.intecbrussel.dao;

import be.intecbrussel.model.GuestbookBean;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class GuestBookDao {

    static {


        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void addGuestBookItem(GuestbookBean message) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://noelvaes.eu/StudentDB", "student", "student123");

            PreparedStatement createStatement = connection.prepareStatement("INSERT INTO GuestBook (Date,Name,Message) VALUES (?,?,?)");
            createStatement.setDate(1, Date.valueOf(message.getDate()));
            createStatement.setString(2, message.getName());
            createStatement.setString(3, message.getMessage());
            createStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public List<GuestbookBean> getGuestBookItems() {
        Connection connection = null;
        List<GuestbookBean> guestbookBeans = new ArrayList<>();


        try {
            connection = DriverManager.getConnection("jdbc:mariadb://noelvaes.eu/StudentDB", "student", "student123");
            PreparedStatement createStatement = connection.prepareStatement("SELECT * FROM GuestBook ");
            ResultSet rs = createStatement.executeQuery();

            while (rs.next()) {

                GuestbookBean guestbookBean = new GuestbookBean();
                guestbookBean.setName(rs.getString("Name"));
                guestbookBean.setDate(rs.getDate("Date").toLocalDate());
                guestbookBean.setMessage(rs.getString("Message"));
                guestbookBeans.add(guestbookBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return guestbookBeans;
    }


    public void deleteGuestBookItem(GuestbookBean message) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://noelvaes.eu/StudentDB", "student", "student123");
            PreparedStatement createStatement = connection.prepareStatement(" DELETE FROM GuestBook WHERE message = ?");
            createStatement.setString(1, message.getMessage());
            createStatement.executeQuery();


        } catch (SQLException e) {

            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}




