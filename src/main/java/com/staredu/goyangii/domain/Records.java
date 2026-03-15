package com.staredu.goyangii.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.attoparser.dom.Text;

import java.util.Date;

public class Records {

    private Date date;
    private Integer pages;
    private Text inspirations;

    @ManyToOne
    @JoinColumn(name = "Bookinfo_bookname")
    private Bookinfo bookinfo;

    public Records(Bookinfo bookinfo, Date date, Integer pages, Text inspirations) {}

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

    public void setInspirations(Text inspirations) {
        this.inspirations = inspirations;
    }
    public Text getInspirations() {
        return inspirations;
    }
}
