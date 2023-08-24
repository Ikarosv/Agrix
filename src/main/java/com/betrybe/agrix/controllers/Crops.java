package com.betrybe.agrix.controllers;

import com.betrybe.agrix.exceptions.NotFound;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.CropsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  /**
   * GET /crops/{id}.
   *
   * @param id Crop id.
   * @return Crop.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Crop> getCropById(@PathVariable Integer id) {
    Crop crop = this.cropsService.getCropById(id);

    if (crop == null) {
      throw new NotFound("Plantação não encontrada!");
    }

    return ResponseEntity.status(HttpStatus.OK).body(crop);
  }
}
