package com.backend.Project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Project1.entity.Facility;
import com.backend.Project1.service.FacilityServiceInterface;

@RestController
public class FacilityCtrl {
    
    @Autowired
    FacilityServiceInterface facilityService;

    @PostMapping("/saveFacility")
    public ResponseEntity<String> createFacility(Facility facility) {
        return new ResponseEntity<>(facilityService.saveFacility(facility), HttpStatus.OK);
    }

    @GetMapping("/getFacilities")
    public ResponseEntity<List<Facility>> getFacilities() {
        try {
            return new ResponseEntity<>(facilityService.getAllFacilities(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getFacilities/{facilityId}")
    public Facility getById(@PathVariable String facilityId) {
        return facilityService.getFacilityById(facilityId);
    }

    @PutMapping("/updateFacility/{facilityId}")
    public ResponseEntity<Facility> changeFacility(@PathVariable String facilityId, @RequestBody Facility facility) {
        return new ResponseEntity<Facility>(facilityService.updateFacility(facilityId, facility), HttpStatus.OK);
    }

    @DeleteMapping("/deleteFacility/{facilityId}")
    public ResponseEntity<String> removeFacility(@PathVariable String facilityId) {
        return new ResponseEntity<String>(facilityService.deleteFacility(facilityId), HttpStatus.OK);
    }
    
}
