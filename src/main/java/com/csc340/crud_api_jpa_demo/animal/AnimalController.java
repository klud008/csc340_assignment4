package com.csc340.crud_api_jpa_demo.animal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animals  objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for a Animal.
     * @return One Student object.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Get a list of Animals based on their species.
     * http://localhost:8080/animals/species_search?species=
     *
     * @param species the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("/species_search")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "") String species) {
        return service.getAnimalsBySpecies(species);
    }

    /**
     * Get a list of Animals based on the searched name.
     * http://localhost:8080/animals/name_search?name=
     *
     * @param keyword the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("/name_search")
    public List<Animal> getAnimalsByName(@RequestParam(name = "name", defaultValue = "") String keyword) {
        return service.getAnimalsByName(keyword);
    }

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new --data '{ "animalId": 4, "name": "Bengal tiger", "scientificName": "Panthera tigris tigris", "species": "Tigris", "habitat": "Asia", "description": "Largest living cat species. Large and powerful with orange fur and black stripes."}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/2 --data '{ "animalId": 90, "name": "Siberian tiger", "scientificName": "Panthera tigris altaica", "species": "Tigris", "habitat": "habitat", "description": "description"}'
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new update Student details.
     * @return the updated Student object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete a Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{studentId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }
}
