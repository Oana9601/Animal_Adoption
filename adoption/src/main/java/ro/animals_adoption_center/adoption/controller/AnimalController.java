package ro.animals_adoption_center.adoption.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.animals_adoption_center.adoption.dto.AnimalDTO;
import ro.animals_adoption_center.adoption.service.AnimalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        List<AnimalDTO> animals = animalService.getAllAnimals();
        return ResponseEntity.ok(animals);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable int id) {
        Optional<AnimalDTO> animal = animalService.getAnimalById(id);
        return animal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/{name}")
    public Optional<AnimalDTO> getAnimalByIdAndPrintName(@PathVariable int id, @PathVariable String name) {
        System.out.println("id: " + id + ", name: " + name);
        return animalService.getAnimalById(id);
    }

    @PostMapping
    public ResponseEntity<AnimalDTO> createAnimal(@RequestBody AnimalDTO animal) {
        AnimalDTO createdAnimal = animalService.createAnimal(animal);
        return ResponseEntity.ok(createdAnimal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAnimal(@PathVariable Long id, @RequestBody AnimalDTO animalDetails) {
        animalService.updateAnimal(id, animalDetails);
        return ResponseEntity.status(HttpStatus.OK).body("Animal updated succesfully! ");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
        return ResponseEntity.ok().body("Client deleted Successfully!");
    }
}
