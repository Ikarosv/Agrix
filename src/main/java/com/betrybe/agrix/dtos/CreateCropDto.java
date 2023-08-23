package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Crop;

/**
 * Create crop DTO.
 */
public record CreateCropDto(String name, Double plantedArea) {
  public Crop toCrop(Integer farmId) {
    return new Crop(null, farmId, name, plantedArea);
  }
}
