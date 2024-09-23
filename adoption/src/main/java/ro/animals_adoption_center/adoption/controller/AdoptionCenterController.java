package ro.animals_adoption_center.adoption.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.animals_adoption_center.adoption.dto.AdoptionCenterDTO;
import ro.animals_adoption_center.adoption.service.AdoptionCenterService;

@RestController
@RequestMapping("/adoption-centers")
public class AdoptionCenterController {

    @Autowired
    private AdoptionCenterService adoptionCenterService;

    @PostMapping
    public String addAdoptionCenter(@RequestParam Long animalId, @RequestBody AdoptionCenterDTO adoptionCenterDTO){
        adoptionCenterService.createAdoptionCenterForAnimal(animalId ,
                                                            adoptionCenterDTO.getCenterName(),
                                                            adoptionCenterDTO.getAddress());

        return "Adoption Center added successfully!";
    }

    @GetMapping
    public AdoptionCenterDTO getAdoptionCenter(@RequestParam Long animalId){
        return adoptionCenterService.getAdoptionCenterForAnimal(animalId);
    }

    @DeleteMapping
    public String deleteAdoptionCenterById(@RequestParam Long adoptionCenterId){
        adoptionCenterService.deleteAdoptionCenter(adoptionCenterId);
        return "Adoption Center deleted successfully!";
    }

}
