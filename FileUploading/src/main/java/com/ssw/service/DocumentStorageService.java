package com.ssw.service;

import com.ssw.entity.Documents;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DocumentStorageService {
    Documents storeDocument(MultipartFile doc) throws IOException;

    Documents getDocument(String docId);
}
