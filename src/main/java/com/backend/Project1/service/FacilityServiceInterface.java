package com.backend.Project1.service;

import java.util.List;

import com.backend.Project1.entity.Facility;

public interface FacilityServiceInterface {
    
    public String saveFacility(Facility facility);
    public List<Facility> getAllFacilities();
    public Facility getFacilityById(String facilityId);
    public Facility updateFacility(String facilityId, Facility facility);
    public String deleteFacility(String facilityId);
    
}
