package ro.animals_adoption_center.adoption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.animals_adoption_center.adoption.dto.AdoptionCenterDTO;
import ro.animals_adoption_center.adoption.mapper.AdoptionCenterMapper;
import ro.animals_adoption_center.adoption.model.AdoptionCenter;
import ro.animals_adoption_center.adoption.model.Animal;
import ro.animals_adoption_center.adoption.repository.AdoptionCenterRepository;
import ro.animals_adoption_center.adoption.repository.AnimalRepository;

import java.util.Optional;

@Service
public class AdoptionCenterService {

    @Autowired
    private AdoptionCenterRepository adoptionCenterRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public void createAdoptionCenterForAnimal(Long animalId, String centerName, String address){
        Animal animal = animalRepository.findById(animalId).orElseThrow();

        AdoptionCenter adoptionCenter = new AdoptionCenter();
        adoptionCenter.setCenterName(centerName);
        adoptionCenter.setAddress(address);
        adoptionCenterRepository.save(adoptionCenter);
    }

    public AdoptionCenterDTO getAdoptionCenterForAnimal(Long animalId){
        Animal animal = animalRepository.findById(animalId).orElseThrow();
        Optional<AdoptionCenter> adoptionCenterByAnimalId = adoptionCenterRepository.findByAnimalId(animal.getId());
        AdoptionCenterDTO adoptionCenterDto = new AdoptionCenterDTO();

        if(adoptionCenterByAnimalId.get() != null) {
            adoptionCenterDto = AdoptionCenterMapper.toDTO(adoptionCenterByAnimalId.get());
        }

        return adoptionCenterDto;

    }

    public void deleteAdoptionCenter(Long adoptionCenterId){
        adoptionCenterRepository.deleteById(adoptionCenterId);
    }

}
