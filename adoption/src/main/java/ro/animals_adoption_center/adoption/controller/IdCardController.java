package ro.animals_adoption_center.adoption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.animals_adoption_center.adoption.dto.IdCardDto;
import ro.animals_adoption_center.adoption.service.IdCardService;

@RestController
@RequestMapping("/id-cards")
public class IdCardController {

    @Autowired
    private IdCardService idCardService;

    @PostMapping
    public String addIdCard(@RequestParam Long animalId){
        idCardService.createIdCardForAnimal(animalId);
        return "Id Card added successfully! ";
    }

    @GetMapping
    public IdCardDto getIdCard(@RequestParam Long animalId){
        return idCardService.getIdCardForAnimal(animalId);
    }

}
