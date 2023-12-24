package com.backend.Project1.service;

import org.springframework.web.multipart.MultipartFile;

import com.backend.Project1.entity.Attachment;

public interface AttachmentServiceInterface {

    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
    
}
