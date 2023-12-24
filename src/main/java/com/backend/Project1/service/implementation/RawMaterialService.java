package com.backend.Project1.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Project1.entity.RawMaterial;
import com.backend.Project1.exception.MaterialNotFoundException;
import com.backend.Project1.repository.RawMaterialRepo;
import com.backend.Project1.service.RawMaterialServiceInterface;

@Service
public class RawMaterialService implements RawMaterialServiceInterface {
    
    @Autowired
    RawMaterialRepo materialRepo;

    @Override
    public String saveMaterial(RawMaterial rawMaterial) {
        String materialId = rawMaterial.getMaterialId();
        Optional<RawMaterial> existingId = materialRepo.findById(materialId);

        if (existingId.isPresent())
            return "RawMaterial already exists";
            
        else {
            materialRepo.save(rawMaterial);
            return "RawMaterial " + materialId + " saved";
        } 
    }

    @Override
    public List<RawMaterial> getAllMaterial() {
       return materialRepo.findAll();
    }

    @Override
    public RawMaterial getById(String materialId) {
        return materialRepo.findById(materialId).get();
    }

    @Override
    public RawMaterial updateMaterial(String materialId, RawMaterial material) throws MaterialNotFoundException {
        Optional<RawMaterial> existing = materialRepo.findById(materialId);
        RawMaterial existingMaterial = null;

        if (existing.isPresent()) {
            existingMaterial = existing.get();
            existingMaterial.setMaterialName(material.getMaterialName());
            existingMaterial.setMaterialTier(material.getMaterialTier());
            existingMaterial.setMaterialPrice(material.getMaterialPrice());
            existingMaterial.setQuantity(material.getQuantity());
            existingMaterial.setFacilityId(material.getFacilityId());

            materialRepo.save(existingMaterial);
        }

        if (existingMaterial == null) {
            throw new MaterialNotFoundException("Material Not found");
        }

        return existingMaterial;
    }

    @Override
    public String deleteMaterial(String materialId) {
        boolean deleted = false;
        if (materialRepo.existsById(materialId)) {
            materialRepo.deleteById(materialId);
            deleted = true;
        }
        
        return "Material id " + materialId + " deletion status : " + deleted;
    }
}
