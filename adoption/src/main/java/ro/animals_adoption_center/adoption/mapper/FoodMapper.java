package ro.animals_adoption_center.adoption.mapper;

import org.springframework.stereotype.Component;
import ro.animals_adoption_center.adoption.dto.AnimalDTO;
import ro.animals_adoption_center.adoption.dto.FoodDTO;
import ro.animals_adoption_center.adoption.model.Animal;
import ro.animals_adoption_center.adoption.model.Food;

@Component
public class FoodMapper {

    public static FoodDTO toDTO(Food food) {
        FoodDTO dto = new FoodDTO();
        dto.setSpecies(food.getSpecies());
        dto.setBrand(food.getBrand());

        return dto;
    }

    public static Food toEntity(FoodDTO foodDTO) {
        Food food = new Food();
        food.setBrand(foodDTO.getBrand());
        food.setSpecies(foodDTO.getSpecies());

        return food;
    }

}
