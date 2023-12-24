package com.backend.Project1.service;

import java.util.List;

import com.backend.Project1.entity.RawMaterial;
import com.backend.Project1.exception.MaterialNotFoundException;

public interface RawMaterialServiceInterface {
    
    public String saveMaterial(RawMaterial rawMaterial);
    public List<RawMaterial> getAllMaterial();
    public RawMaterial getById(String materialId);
    public RawMaterial updateMaterial(String materialId, RawMaterial material) throws MaterialNotFoundException;
    public String deleteMaterial(String materialId);

}
