package com.testehan.htmx.ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @PostMapping()
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println("File " + file.getOriginalFilename() + " was uploaded and has a size of " + file.getSize());
        return "redirect:/";
    }
}
