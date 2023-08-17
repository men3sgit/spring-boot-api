package com.menes.controllers;

import com.menes.models.ResponseObject;
import com.menes.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Controller
@RequestMapping(path = "upload")
public class FileUploadControllerr {
    private final PhotoService photoService;
@Autowired
    public FileUploadControllerr(PhotoService photoService) {
        this.photoService = photoService;
    }


    @PostMapping
    public ResponseEntity<ResponseObject> registerNewPhoto(@RequestParam("file") MultipartFile file)  {
            photoService.storeFile(file);
        return ResponseEntity.ok().body(new ResponseObject(200,"file",file.getOriginalFilename()));
    }
}
