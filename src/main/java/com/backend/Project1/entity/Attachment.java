package com.backend.Project1.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attachment {

    @Id
    private String id;
    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

    public Attachment(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
    
}
