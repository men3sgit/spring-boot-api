package com.menes.controllers;

import com.menes.models.PhotoDetails;
import com.menes.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("photos",photoService.getAllPhotos());
        return "index";
    }
    

}
