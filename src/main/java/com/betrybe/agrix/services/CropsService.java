package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.repositories.CropRepository;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Crops service.
 */
@Service
public class CropsService {
  CropRepository cropRepository;

  /**
   * Constructor.
   *
   * @param cropRepository Crop repository.
   */
  @Autowired
  public CropsService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  public Crop createCrop(Crop crop) {
    return cropRepository.save(crop);
  }

  public Stream<Crop> getCropsByFarmId(Integer farmId) {
    return cropRepository.findAll().stream().filter(crop -> crop.getFarmId()
        .equals(farmId));
  }
}
