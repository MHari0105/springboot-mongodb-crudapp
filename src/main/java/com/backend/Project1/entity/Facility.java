package com.backend.Project1.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Facility")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    
    @Id
    private String facilityId;
    private String facilityName;
    private List<String> materials;
    private List<String> supplierId;
    private String location;
    
}
