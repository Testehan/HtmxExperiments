package com.testehan.htmx.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class DialogController {

    @PostMapping("/submit")
    public String createItem(Model model, @RequestHeader("HX-Prompt") String information) {
        model.addAttribute("information", information);
        return "fragments/someInformation";
    }

    @GetMapping("/modal")
    public String getModalDialog(){
        return "fragments/modal";
    }


}
