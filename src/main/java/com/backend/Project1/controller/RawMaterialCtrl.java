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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Project1.entity.RawMaterial;
import com.backend.Project1.exception.MaterialNotFoundException;
import com.backend.Project1.service.RawMaterialServiceInterface;

@RestController
@RequestMapping("rawMaterial")
public class RawMaterialCtrl {
    
    @Autowired
    RawMaterialServiceInterface materialService;

    @PostMapping("/save")
    public ResponseEntity<String> createMaterial(@RequestBody RawMaterial rawMaterial) {
        return new ResponseEntity<>(materialService.saveMaterial(rawMaterial), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<RawMaterial>> getMaterials() {
        try {
            return new ResponseEntity<>(materialService.getAllMaterial(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }

    @GetMapping("/get/{materialId}")
    public ResponseEntity<RawMaterial> getMaterialById(@PathVariable String materialId) {
        try {
            return new ResponseEntity<RawMaterial>(materialService.getById(materialId), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<RawMaterial>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{materialId}")
    public ResponseEntity<RawMaterial> updateMaterial( @PathVariable String materialId, @RequestBody RawMaterial rawMaterial) throws MaterialNotFoundException {
        return new ResponseEntity<RawMaterial>(materialService.updateMaterial(materialId, rawMaterial), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{materialId}")
    public ResponseEntity<String> deleteMaterial(@PathVariable String materialId) {
        return new ResponseEntity<>(materialService.deleteMaterial(materialId), HttpStatus.OK);
    }
}
