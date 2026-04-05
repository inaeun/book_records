package com.staredu.goyangii.controller;
import java.time.LocalDate;
import java.util.Date;

public class RecordsForm {
    private LocalDate date;
    private Integer pages;
    private String inspirations;

    public LocalDate getDate() { return date;}
    public void setDate(LocalDate date) { this.date = date;}

    public Integer getPages() { return pages;}
    public void setPages(Integer pages) { this.pages = pages;}

    public String getInspirations() { return inspirations;}
    public void setInspirations(String inspirations) { this.inspirations = inspirations;}
}
