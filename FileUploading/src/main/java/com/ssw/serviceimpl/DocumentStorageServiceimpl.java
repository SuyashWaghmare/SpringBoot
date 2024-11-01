package com.ssw.serviceimpl;

import com.ssw.entity.Documents;
import com.ssw.exception.FileStorageException;
import com.ssw.exception.MyFileNotFoundException;
import com.ssw.repository.DocumentRepository;
import com.ssw.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class DocumentStorageServiceimpl implements DocumentStorageService {

    @Autowired
    private DocumentRepository  documentRepository;


    @Override
    public Documents storeDocument(MultipartFile doc) throws IOException {

        String documentName = StringUtils.cleanPath(doc.getOriginalFilename());

        try {
            if (documentName.contains(".."))
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + documentName);


            Documents document = new Documents();
            document.setDocumentName(documentName);
            document.setDocumentType(doc.getContentType());
            document.setData(doc.getBytes());

            return documentRepository.save(document);
        } catch (IOException e) {
            throw new FileStorageException("Could not store file " + documentName + ". Please try again.");
        }


    }

    @Override
    public Documents getDocument(String fileId) {
        return documentRepository.findById(fileId).orElseThrow(()-> new MyFileNotFoundException("Document with this ID is not found : "+fileId));
    }
}
