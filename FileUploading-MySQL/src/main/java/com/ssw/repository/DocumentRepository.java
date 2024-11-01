package com.ssw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ssw.model.Document;


@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {

}
