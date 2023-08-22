package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Farm;

public record FarmsDto(Integer id, String name, Double size) {
  public Farm toFarm() {
    return new Farm(id, name, size);
  }
}
