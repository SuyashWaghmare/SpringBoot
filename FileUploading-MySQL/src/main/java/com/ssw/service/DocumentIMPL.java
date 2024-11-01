package com.ssw.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssw.model.Document;
import com.ssw.repository.DocumentRepository;

@Service
public class DocumentIMPL implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public String saveDocument(Document document) {

		String docId = UUID.randomUUID().toString().toUpperCase();
		document.setDocId(docId);
		documentRepository.save(document);

		return "Document Uploaded";
	}

}
