package com.staredu.goyangii.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.attoparser.dom.Text;

import java.util.Date;

public class Records {

    private Date date;
    private Integer pages;
    private String inspirations;

    @ManyToOne
    @JoinColumn(name = "Bookinfo_bookname")
    private Bookinfo bookinfo;


    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
    public Integer getPages() {
        return pages;
    }

    public void setInspirations(String inspirations) {
        this.inspirations = inspirations;
    }
    public String getInspirations() {
        return inspirations;
    }
}
