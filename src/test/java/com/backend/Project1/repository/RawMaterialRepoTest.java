package com.backend.Project1.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.backend.Project1.entity.RawMaterial;

@DataMongoTest
public class RawMaterialRepoTest {
    
    @Autowired
    private RawMaterialRepo rawMaterialRepo;

    @Test
    public void RawMaterialRepo_saveAll_returnSavedRawMaterial() {

        // ARRANGE
        RawMaterial rawMaterial = RawMaterial.builder()
                                    .materialName("rm100")
                                    .materialTier(2)
                                    .quantity(10.5)
                                    .materialPrice(10000.0).build();

        
        // ACT
        RawMaterial savedRawMaterial = rawMaterialRepo.save(rawMaterial);


        // ASSERT
        Assertions.assertThat(savedRawMaterial).isNotNull();
        Assertions.assertThat(savedRawMaterial.getMaterialId()).isGreaterThan("0");
    }

    @Test
    public void RawMaterial_getAll_returnMoreThanOneMaterial() {

        RawMaterial rawMaterial1 = RawMaterial.builder()
                                    .materialName("rm100")
                                    .materialTier(2)
                                    .quantity(10.5)
                                    .materialPrice(10000.0).build();

        RawMaterial rawMaterial2 = RawMaterial.builder()
                                    .materialName("rm100")
                                    .materialTier(2)
                                    .quantity(10.5)
                                    .materialPrice(10000.0).build();

        rawMaterialRepo.save(rawMaterial1);
        rawMaterialRepo.save(rawMaterial2);

        List<RawMaterial> rawMaterialLists = rawMaterialRepo.findAll();

        Assertions.assertThat(rawMaterialLists).isNotNull();
        Assertions.assertThat(rawMaterialLists.size()).isGreaterThan(2);

    }

    @Test
    public void RawMaterial_findById_returnMoreThanOneMaterial() {
        
        RawMaterial rm = RawMaterial.builder()
                            .materialName("Leather")
                            .materialTier(2)
                            .quantity(10.5)
                            .materialPrice(15000.0)
                            .build();
        
        rawMaterialRepo.save(rm);

        RawMaterial rmFind = rawMaterialRepo.findById(rm.getMaterialId()).get();

        Assertions.assertThat(rmFind).isEqualTo(rmFind);
    }
}
