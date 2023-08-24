package com.betrybe.agrix.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * This class represents a farm.
 */
@Entity
@Table(name = "farms")
public class Farm {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Double size;
  @OneToMany
  @JsonIgnore
  private List<Crop> crops;

  public List<Crop> getCrops() {
    return crops;
  }

  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }


  /**
   * The farm's constructor.
   *
   * @param id The farm's id.
   * @param name The farm's name.
   * @param size The farm's size.
   */
  public Farm(Integer id, String name, Double size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }

  public Farm() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }
}
