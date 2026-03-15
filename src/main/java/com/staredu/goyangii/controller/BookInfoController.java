package com.staredu.goyangii.controller;

import com.staredu.goyangii.domain.Bookinfo;
import com.staredu.goyangii.service.BookInfoService;
//import com.staredu.goyangii.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookInfoController {

    private BookInfoService bookInfoService;

    @Autowired
    public BookInfoController(BookInfoService bookInfoService) {
        this.bookInfoService = bookInfoService;
    }

    @GetMapping(value = "/bookinfos/new")
    public String createForm() {
        return "bookinfos/createBookinfoForm";
    }

    @PostMapping(value = "/bookinfos/new")
    public String create(BookInfoForm form) {

        Bookinfo bookinfo = new Bookinfo();
        bookinfo.setBookname(form.getBookname());
        bookinfo.setAuthor(form.getAuthor());
        bookinfo.setGenre(form.getGenre());

       // System.out.println("Member name is " + form.getName());

        bookInfoService.join(bookinfo);

        return "redirect:/";
    }

    @GetMapping(value = "bookinfos")
    public String list(Model model) {

        List<Bookinfo> bookinfos = bookInfoService.findBookinfo();
        model.addAttribute("bookinfos", bookinfos);

        return "bookinfos/bookinfoList";
    }
}
