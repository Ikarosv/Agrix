package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface represents the repository for the Crop entity.
 */
public interface CropRepository extends JpaRepository<Crop, Integer> {
}
