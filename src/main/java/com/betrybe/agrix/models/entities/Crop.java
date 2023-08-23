package com.betrybe.agrix.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


/**
 * Crop entity.
 */
@Entity
@Table(name = "crops")
public class Crop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(name = "farmId")
  private Integer farmId;
  private String name;
  private Double plantedArea;
  @ManyToOne
  @JoinColumn(name = "farmId", insertable = false, updatable = false)
  private Farm farm;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getFarmId() {
    return farmId;
  }

  public void setFarmId(Integer farmId) {
    this.farmId = farmId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }


  /**
   * Crop constructor.
   *
   * @param id Crop id.
   * @param farmId Crop farm id.
   * @param name Crop name.
   * @param plantedArea Crop planted area.
   */
  public Crop(Integer id, Integer farmId, String name, Double plantedArea) {
    this.id = id;
    this.farmId = farmId;
    this.name = name;
    this.plantedArea = plantedArea;
  }
}
