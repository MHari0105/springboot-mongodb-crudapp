package com.backend.Project1.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    
    @Id
    private String supplierId;
    private String supplierName;
    private String materialName;
    private double supplierCharge;
    private String facilityName;
    
}
