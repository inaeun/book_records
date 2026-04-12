package com.staredu.goyangii.controller;

import com.staredu.goyangii.domain.Bookinfo;
import com.staredu.goyangii.service.BookInfoService;
//import com.staredu.goyangii.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TitlepageController {

    private BookInfoService bookInfoService;

    @Autowired
    public TitlepageController(BookInfoService bookInfoService) { this.bookInfoService = bookInfoService; }

    @GetMapping(value = "booktitles")
    public String list(Model model) {

        List<Bookinfo> bookinfos = bookInfoService.findBookinfo();
        model.addAttribute("bookinfos", bookinfos);

        return "bookinfos/titlepage";
    }

    @GetMapping(value = "/bookinfos/titlepage")
    public String titlePage(Model model) {
        List<Bookinfo> bookinfos = bookInfoService.findBookinfo();
        model.addAttribute("bookinfos", bookinfos);
        return "bookinfos/titlepage"; // templates/bookinfos/titlepage.html을 찾아감
    }
}

