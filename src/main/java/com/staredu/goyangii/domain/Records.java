package com.staredu.goyangii.domain;

import jakarta.persistence.*;
import org.attoparser.dom.Text;

import java.util.Date;

@Entity
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private Integer pages;
    private String inspirations;

    @ManyToOne
    @JoinColumn(name = "bookinfo_id")
    private Bookinfo bookinfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
