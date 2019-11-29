package be.intecbrussel.model;

import java.time.LocalDate;

public class GuestbookBean {

    private LocalDate date;
    private String name;
    private String message;


    public GuestbookBean(LocalDate date, String name, String message) {
        this.date = date;
        this.name = name;
        this.message = message;
    }

    public GuestbookBean() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "GuestbookBean{" +
                "date=" + date +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
