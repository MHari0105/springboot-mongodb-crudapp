package com.backend.Project1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.Project1.entity.Attachment;

@Repository
public interface AttachmentRepo extends MongoRepository<Attachment, String> {
    
}
