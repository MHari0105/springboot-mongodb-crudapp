package com.backend.Project1.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "CustomerOrder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {
    
    @Id
    private String customerId;
    private String customerName;
    private List<String> materials;
    private double availableCash;
    private String customerAddress;
    
}
