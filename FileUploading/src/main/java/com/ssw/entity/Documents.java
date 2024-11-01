package com.ssw.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Documents {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String documentName;

    private String documentType;

    @Lob
    private byte[] data;


}
