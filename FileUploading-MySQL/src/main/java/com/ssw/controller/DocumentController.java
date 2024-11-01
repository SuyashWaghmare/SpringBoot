package com.ssw.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssw.app.response.ApiResponse;
import com.ssw.model.Document;
import com.ssw.service.DocumentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/doc-api")

public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = {"application/json" })
    public ResponseEntity<ApiResponse> saveDocument(@RequestPart MultipartFile f1, @RequestPart MultipartFile f2,
            @RequestPart MultipartFile f3, @RequestPart MultipartFile f4) {
        
        Document document = new Document();

        try {
            document.setAdharCard(f1.getBytes());
            document.setLicense(f2.getBytes());
            document.setPanCard(f3.getBytes());
            document.setPhoto(f4.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String msg = documentService.saveDocument(document);
       // ApiResponse response = new ApiResponse(msg);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.builder().resp(msg).build());
}
}