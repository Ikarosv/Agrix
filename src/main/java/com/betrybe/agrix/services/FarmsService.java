package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * This class represents the service for the Farm entity.
 */
@Service
public class FarmsService {
  private final FarmRepository farmRepository;

  /**
   * Constructor.
   *
   * @param farmRepository Farm repository.
   */
  @Autowired
  public FarmsService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   *  Creates a farm.
   *
   * @param farm The farm to be created.
   * @return The created farm.
   */
  public Farm createFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   *  Gets farms.
   *
   * @return The farms.
   */
  public List<Farm> getFarms() {
    return farmRepository.findAll();
  }

  /**
   *  Gets a farm by id.
   *
   * @return The farm.
   */
  public Farm getFarmById(Integer id) {
    return farmRepository.findById(id).orElse(null);
  }
}
