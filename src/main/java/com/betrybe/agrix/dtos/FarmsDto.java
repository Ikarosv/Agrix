package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Farm;

/**
 * Farms DTO.
 *
 * @param id id.
 * @param name name.
 * @param size size.
 */
public record FarmsDto(Integer id, String name, Double size) {
  /**
   * Change to farm.
   *
   * @return The farm.
   */
  public Farm toFarm() {
    return new Farm(id, name, size);
  }
}
