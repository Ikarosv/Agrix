package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.CreateCropDto;
import com.betrybe.agrix.dtos.FarmsDto;
import com.betrybe.agrix.exceptions.NotFound;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.CropsService;
import com.betrybe.agrix.services.FarmsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farms controller.
 */
@RestController
@RequestMapping("/farms")
public class Farms {
  private final FarmsService farmsService;
  private final CropsService cropsService;

  /**
   * Constructor.
   *
   * @param farmsService Farms service.
   */
  @Autowired
  public Farms(FarmsService farmsService, CropsService cropsService) {
    this.farmsService = farmsService;
    this.cropsService = cropsService;
  }

  /**
   * POST /farms.
   */
  @PostMapping()
  public ResponseEntity<Farm> postFarm(@RequestBody FarmsDto farm) {
    Farm farmEntity = this.farmsService.createFarm(farm.toFarm());

    return ResponseEntity.status(HttpStatus.CREATED).body(farmEntity);
  }

  @GetMapping()
  public ResponseEntity<List<Farm>> getFarm() {
    return ResponseEntity.status(HttpStatus.OK).body(this.farmsService.getFarms());
  }

  /**
   * GET /farms/{id}.
   *
   * @param id The farm's id.
   * @return The farm.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Farm> getFarmById(@PathVariable Integer id) {
    Optional<Farm> farm = Optional.ofNullable(this.farmsService.getFarmById(id));
    if (farm.isEmpty()) {
      throw new NotFound("Fazenda não encontrada!");
    }

    return ResponseEntity.status(HttpStatus.OK).body(farm.get());
  }

  /**
   * POST /farms/{id}/crops.
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<Crop> postCrop(
      @PathVariable Integer farmId, @RequestBody CreateCropDto crop
  ) {
    Farm farm = this.farmsService.getFarmById(farmId);
    if (farm == null) {
      throw new NotFound("Fazenda não encontrada!");
    }
    Crop farmEntity = this.cropsService.createCrop(crop.toCrop(farmId));

    return ResponseEntity.status(HttpStatus.CREATED).body(farmEntity);
  }
}
