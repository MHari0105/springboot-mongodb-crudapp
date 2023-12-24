package com.backend.Project1.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "RawMaterial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RawMaterial {
    
    @Id
    private String materialId;
    private String materialName;
    private int materialTier;
    private double quantity;
    private double materialPrice;
    private List<String> facilityId;

}

