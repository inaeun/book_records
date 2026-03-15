package com.staredu.goyangii.controller;

public class BookInfoForm {
    private String bookname;
    private String author;
    private String genre;

    public String getBookname() {
        return bookname;
    }
    public void setBookname(String name) {
        this.bookname = name;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

}
