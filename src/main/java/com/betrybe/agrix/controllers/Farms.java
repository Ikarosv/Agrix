package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.FarmsDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

  /**
   * Constructor.
   *
   * @param farmsService Farms service.
   */
  public Farms(FarmsService farmsService) {
    this.farmsService = farmsService;
  }

  /**
   * POST /farms.
   */
  @PostMapping()
  public ResponseEntity<Farm> postFarm(@RequestBody FarmsDto farm) {
    Farm farmEntity = this.farmsService.createFarm(farm.toFarm());
    System.out.println(farmEntity);

    return ResponseEntity.status(HttpStatus.CREATED).body(farmEntity);
  }
}