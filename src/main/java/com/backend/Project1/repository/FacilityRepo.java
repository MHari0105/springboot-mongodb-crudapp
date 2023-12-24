package com.backend.Project1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.Project1.entity.Facility;

public interface FacilityRepo extends MongoRepository<Facility, String> {
    
}
