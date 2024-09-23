package ro.animals_adoption_center.adoption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.animals_adoption_center.adoption.dto.FoodDTO;
import ro.animals_adoption_center.adoption.exceptions.FoodNotFoundException;
import ro.animals_adoption_center.adoption.model.Animal;
import ro.animals_adoption_center.adoption.model.Food;
import ro.animals_adoption_center.adoption.repository.AnimalRepository;
import ro.animals_adoption_center.adoption.repository.FoodRepository;
import ro.animals_adoption_center.adoption.mapper.FoodMapper;


import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private AnimalRepository animalRepository;


    public void addFood(String species, String brand){

        Food food = new Food();
        food.setSpecies(species);
        food.setBrand(brand);

        foodRepository.save(food);
    }

    public FoodDTO getFoodForAnimal(Long animalId){
        Animal animal = animalRepository.findById(animalId).orElseThrow();
        Optional<Food> foodByAnimalId = Optional.ofNullable(foodRepository.findByAnimalId(animal.getId()).orElseThrow(() -> new FoodNotFoundException("Food not found!")));
        FoodDTO foodDto = new FoodDTO();

        if(foodByAnimalId.get() != null) {
            foodDto = FoodMapper.toDTO(foodByAnimalId.get());
        }

        return foodDto;
    }

    public void deleteFoodBrand(Long foodId){
        foodRepository.deleteById(foodId);
    }
}
