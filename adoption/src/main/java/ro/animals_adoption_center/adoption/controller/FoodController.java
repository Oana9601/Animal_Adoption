package ro.animals_adoption_center.adoption.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.animals_adoption_center.adoption.dto.AdoptionCenterDTO;
import ro.animals_adoption_center.adoption.dto.FoodDTO;
import ro.animals_adoption_center.adoption.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public String addFoodBrand(@RequestBody FoodDTO foodDTO){
        foodService.addFood(foodDTO.getSpecies(), foodDTO.getBrand());
        return "Food added successfully!";
    }

    @GetMapping
    public FoodDTO getFoodForAnimal(@RequestParam Long animalId){
        return foodService.getFoodForAnimal(animalId);
    }

    @DeleteMapping
    public String deleteFoodBrand(@RequestParam Long foodId){
        foodService.deleteFoodBrand(foodId);
        return "Food deleted successfully!";
    }
}
