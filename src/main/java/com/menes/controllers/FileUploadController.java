package com.menes.controllers;

import com.menes.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/api/v1/file-upload")
public class FileUploadController {
    @Autowired
    private IStorageService storageService;



    @PostMapping
    public ResponseEntity<String> registerNewImage(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            String generatedFileName = storageService.storeFile(file);
            return ResponseEntity.ok().body("upload success " + generatedFileName);
        } catch (Exception exception) {
            throw new Exception("Failed up load file.", exception);
        }
    }

    @GetMapping(value = "/images/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("imageName") String imageName) throws Exception {
        try {
            byte[] data = storageService.readFileContent(imageName);
            return ResponseEntity.ok().body(data);
        } catch (Exception exception) {
            throw new Exception("Cannot read file", exception);
        }
    }


}
