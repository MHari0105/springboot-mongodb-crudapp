package com.backend.Project1.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.backend.Project1.entity.Attachment;
import com.backend.Project1.repository.AttachmentRepo;
import com.backend.Project1.service.AttachmentServiceInterface;

@Service
public class AttachmentService implements AttachmentServiceInterface {

    @Autowired
    AttachmentRepo attachmentRepo;

    public AttachmentService(AttachmentRepo attachmentRepo) {
        this.attachmentRepo = attachmentRepo;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains(".."))
                throw new Exception("Invalid Filename path" + fileName);
            
                Attachment attachment = new Attachment(fileName, file.getOriginalFilename(), file.getBytes());
                return attachmentRepo.save(attachment);
        }
        catch (Exception e) {
            throw new Exception("Could not save file : " + fileName);
        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepo.findById(fileId)
                .orElseThrow(() -> new Exception("File not found : " + fileId));
    }
    
}
