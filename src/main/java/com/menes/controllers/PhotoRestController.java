package com.menes.controllers;

import com.menes.models.ResponseObject;
import com.menes.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/photos")
public class PhotoRestController {
    private final PhotoService photoService;
    @Autowired
    public PhotoRestController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public ResponseEntity<ResponseObject> getAllPhotos(){
        return ResponseEntity.ok()
                .body(new ResponseObject(HttpStatus.OK.value(), "all photos",photoService.getAllPhotos()));
    }


}
