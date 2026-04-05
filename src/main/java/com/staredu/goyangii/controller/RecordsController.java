package com.staredu.goyangii.controller;

import com.staredu.goyangii.domain.Bookinfo;
import com.staredu.goyangii.domain.Records;
import com.staredu.goyangii.controller.RecordsForm;
import com.staredu.goyangii.service.BookInfoService;
//import com.staredu.goyangii.service.MemberService;
import com.staredu.goyangii.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;


@Controller
public class RecordsController {

    private RecordsService recordsService;

    @Autowired
    public RecordsController(RecordsService recordsService) { this.recordsService = recordsService; }

    @GetMapping(value = "/records/new")
    public String createForm() { return "records/createRecordsForm";}

    @PostMapping(value = "/records/new")
    public String create(RecordsForm form) {

        Records records = new Records();
        records.setDate(form.getDate());
        records.setPages(form.getPages());
        records.setInspirations(form.getInspirations());

        recordsService.join(records);

        return "redirect:/";
    }

    @GetMapping(value = "records")
    public String list(Model model) {

        List<Records> records = recordsService.findRecords();
        model.addAttribute("records", records);

        return "records/recordslist";
    }
}
