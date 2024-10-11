package com.csc340.crud_api_jpa_demo.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> getAnimalsBySpecies(String species);

    // Finds names based on if they include the keyword.
    @Query(value = "SELECT * FROM animals WHERE animals.name LIKE %:keyword%", nativeQuery = true)
    List<Animal> getAnimalsByName(@Param("keyword") String keyword);

}
