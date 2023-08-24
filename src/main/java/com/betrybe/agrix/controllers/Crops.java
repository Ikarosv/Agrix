package com.betrybe.agrix.controllers;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.CropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Crops.
 */
@RestController
@RequestMapping("/crops")
public class Crops {
    CropsService cropsService;

    @Autowired
    public Crops(CropsService cropsService) {
        this.cropsService = cropsService;
    }

    @GetMapping()
    public ResponseEntity<List<Crop>> getAllCrops() {
        return ResponseEntity.status(HttpStatus.OK).body(this.cropsService.getAllCrops());
    }
}
