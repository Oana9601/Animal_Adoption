package ro.animals_adoption_center.adoption.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.animals_adoption_center.adoption.dto.AnimalDTO;
import ro.animals_adoption_center.adoption.exceptions.AnimalNotFoundException;
import ro.animals_adoption_center.adoption.mapper.AnimalMapper;
import ro.animals_adoption_center.adoption.model.Animal;
import ro.animals_adoption_center.adoption.repository.AnimalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<AnimalDTO> getAllAnimals() {

        return animalRepository.findAll().stream()
                .map(animal -> AnimalMapper.toDTO(animal)).toList();
    }

    public Optional<AnimalDTO> getAnimalById(int id) {

        Animal animal = animalRepository.findById(Long.valueOf(id)).orElseThrow(() -> new AnimalNotFoundException("Animal not found!"));

        return Optional.ofNullable(AnimalMapper.toDTO(animal));
    }

    public AnimalDTO createAnimal(AnimalDTO animalDto) {

        Animal animal = new Animal();
        animal.setAge(animalDto.getAge());
        animal.setBreed(animalDto.getBreed());
        animal.setDescription(animalDto.getDescription());
        animal.setAvailable(animalDto.getAvailable());

        animalRepository.save(animal);

        return animalDto;
    }

    public void updateAnimal(Long id, AnimalDTO animalDetails) {

        Animal animal = animalRepository.findById(id).orElseThrow(() -> new AnimalNotFoundException("Animal not found!"));
        animal.setName(animalDetails.getName() != null ? animalDetails.getName() : animal.getName());
        animal.setSpecies(animalDetails.getSpecies() != null ? animalDetails.getSpecies() : animal.getSpecies());
        animal.setAge(animalDetails.getAge() != null ? animalDetails.getAge() : animal.getAge());
        animal.setBreed(animalDetails.getBreed() != null ? animalDetails.getBreed() : animal.getBreed());
        animal.setDescription(animalDetails.getDescription() != null ? animalDetails.getDescription() : animal.getDescription());
        animal.setAvailable(animalDetails.getAvailable() != null ? animalDetails.getAvailable() : animal.getAvailable());

        animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

}
