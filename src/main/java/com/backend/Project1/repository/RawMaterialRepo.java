package com.backend.Project1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.Project1.entity.RawMaterial;

public interface RawMaterialRepo extends MongoRepository<RawMaterial, String> {
    
}
