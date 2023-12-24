package com.backend.Project1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.Project1.entity.CustomerOrder;

public interface CustomerOrderRepo extends MongoRepository<CustomerOrder, String> {
    
}
