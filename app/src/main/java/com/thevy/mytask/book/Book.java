package com.thevy.mytask.book;

public class Book {
    String title;
    String author;
    String startDay;
    String dayRead;
    String numberPage;

    public Book(String title, String author, String startDay, String dayRead, String numberPage) {
        this.title = title;
        this.author = author;
        this.startDay = startDay;
        this.dayRead = dayRead;
        this.numberPage = numberPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getDayRead() {
        return dayRead;
    }

    public void setDayRead(String dayRead) {
        this.dayRead = dayRead;
    }

    public String getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(String numberPage) {
        this.numberPage = numberPage;
    }
}
