package com.ssw.payload;


import lombok.Data;

@Data
public class DocumentUploadResponse {


    private String documentName;
    private String documentDownloadUri;
    private String documentType;
    private long size;


}
