package com.betrybe.agrix.models.repositories;


import com.betrybe.agrix.models.entities.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface represents the repository for the Farm entity.
 */
public interface FarmRepository extends JpaRepository<Farm, Integer> {
}
