package ro.animals_adoption_center.adoption.mapper;

import org.springframework.stereotype.Component;
import ro.animals_adoption_center.adoption.dto.AnimalDTO;
import ro.animals_adoption_center.adoption.model.Animal;

@Component
public class AnimalMapper {

    public static AnimalDTO toDTO(Animal animal) {
        AnimalDTO dto = new AnimalDTO();
        dto.setId(animal.getId());
        dto.setName(animal.getName());
        dto.setSpecies(animal.getSpecies());
        dto.setAge(animal.getAge());
        dto.setBreed(animal.getBreed());
        dto.setDescription(animal.getDescription());
        dto.setAvailable(animal.getAvailable());
        return dto;
    }

    public static Animal toEntity(AnimalDTO animalDTO) {
        Animal animal = new Animal();
        animal.setName(animalDTO.getName());
        animal.setSpecies(animalDTO.getSpecies());
        animal.setAge(animalDTO.getAge());
        animal.setBreed(animalDTO.getBreed());
        animal.setDescription(animalDTO.getDescription());
        animal.setAvailable(animalDTO.getAvailable());
        return animal;
    }
}
