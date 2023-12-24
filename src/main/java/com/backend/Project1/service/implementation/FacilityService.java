package com.backend.Project1.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Project1.entity.Facility;
import com.backend.Project1.repository.FacilityRepo;
import com.backend.Project1.service.FacilityServiceInterface;

@Service
public class FacilityService implements FacilityServiceInterface {

    @Autowired
    private FacilityRepo facilityRepo;
    
    @Override
    public String saveFacility(Facility facility) {
        String facilityName = facility.getFacilityName();
        Optional<Facility> existFacility = facilityRepo.findById(facilityName);

        if (existFacility.isPresent()) 
            return "Facility already exists";
        
        else {
            facilityRepo.save(facility);
            return "Facility " + facilityName + " saved";
        }
    }

    @Override
    public List<Facility> getAllFacilities() {
        return facilityRepo.findAll();
    }

    @Override
    public Facility getFacilityById(String facilityId) {
        return facilityRepo.findById(facilityId).get();
    }

    @Override
    public Facility updateFacility(String facilityId, Facility facility) {
        Optional<Facility> existing = facilityRepo.findById(facilityId);
        Facility existingFacility = null;

        if (existing.isPresent()) {
            existingFacility = existing.get();
            existingFacility.setFacilityName(facility.getFacilityName());
            existingFacility.setLocation(facility.getLocation());

            facilityRepo.save(existingFacility);
        }
        
        return existingFacility;
    }

    @Override
    public String deleteFacility(String facilityId) {
        boolean deleted = false;
        if (facilityRepo.existsById(facilityId)) {
            facilityRepo.deleteById(facilityId);
            deleted = true;
        }
        return "Facility Deletion status : " + deleted;
    }

}
