package com.backend.Project1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.Project1.entity.Supplier;

public interface SupplierRepo extends MongoRepository<Supplier, String> {
    
}
