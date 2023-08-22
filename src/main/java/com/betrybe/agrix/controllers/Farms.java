package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.FarmsDto;
import com.betrybe.agrix.exceptions.NotFound;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

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

    return ResponseEntity.status(HttpStatus.CREATED).body(farmEntity);
  }

  @GetMapping()
  public ResponseEntity<List<Farm>> getFarm() {
    return ResponseEntity.status(HttpStatus.OK).body(this.farmsService.getFarms());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Farm> getFarmById(@PathVariable Integer id) {
    Optional<Farm> farm = Optional.ofNullable(this.farmsService.getFarmById(id));
    if (farm.isEmpty()) {
      throw new NotFound("Fazenda não encontrada!");
    }

    return ResponseEntity.status(HttpStatus.OK).body(farm.get());
  }
}
