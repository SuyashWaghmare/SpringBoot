package com.ssw.controller;


import com.ssw.entity.Documents;
import com.ssw.payload.DocumentUploadResponse;
import com.ssw.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DocumentController {

    @Autowired
    private DocumentStorageService documentStorageService;

    @PostMapping("/uploadDocument")
    public DocumentUploadResponse uploadDocument(@RequestPart("file") MultipartFile doc) throws IOException {

        //final String dir = "D:\\JAVA\\TDIT-SpringBoot\\FileUploading\\src\\main\\resources\\static\\downloads";

        Documents documents = documentStorageService.storeDocument(doc);

        String documentDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().
                path("/downloadDocument/").path(documents.getId()).
                toUriString();


        DocumentUploadResponse documentUploadResponse = new DocumentUploadResponse();
        documentUploadResponse.setDocumentName(documents.getDocumentName());
        documentUploadResponse.setDocumentType(doc.getContentType());
        documentUploadResponse.setSize(doc.getSize());
        documentUploadResponse.setDocumentDownloadUri(documentDownloadUri);

        return documentUploadResponse;


    }


    @PostMapping("/uploadMultipleDocument")
    public List<DocumentUploadResponse> uploadMulitpleDocumnets(@RequestParam("files") MultipartFile[] files) {

        return Arrays.asList(files).stream().map(file -> {
            try {
                return uploadDocument(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }


    @GetMapping("/downloadDocument/{docId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String docId) {

        Documents documents = documentStorageService.getDocument(docId);

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(documents.getDocumentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documents.getDocumentName() + "\"")
                .body(new ByteArrayResource(documents.getData()));
    }

}
