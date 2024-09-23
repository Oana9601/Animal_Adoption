package ro.animals_adoption_center.adoption.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.animals_adoption_center.adoption.dto.IdCardDto;
import ro.animals_adoption_center.adoption.mapper.IdCardMapper;
import ro.animals_adoption_center.adoption.model.Animal;
import ro.animals_adoption_center.adoption.model.IdCard;
import ro.animals_adoption_center.adoption.repository.AnimalRepository;
import ro.animals_adoption_center.adoption.repository.IdCardRepository;

import java.util.Optional;

@Service
public class IdCardService {

    @Autowired
    private IdCardRepository idCardRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public void createIdCardForAnimal(Long animalId, String series, String animalSex){
        Animal animal = animalRepository.findById(animalId).orElseThrow();

        IdCard idCard = new IdCard();
        idCard.setSpecies(animal.getSpecies());
        idCard.setAge(animal.getAge());
        idCard.setBreed(animal.getBreed());
        idCard.setDescription(animal.getDescription());
        idCard.setSeries(series);
        idCard.setAnimalSex(animalSex);

        idCardRepository.save(idCard);
    }

    public IdCardDto getIdCardForAnimal(Long animalId){
        Animal animal = animalRepository.findById(animalId).orElseThrow();

        Optional<IdCard> idCardByAnimalId = idCardRepository.findByAnimalId(animal.getId());
        IdCardDto idCardDto = new IdCardDto();

        if(idCardByAnimalId.get() != null) {
            idCardDto = IdCardMapper.toDTO(idCardByAnimalId.get());
        }

        return idCardDto;
    }

    public void deleteIdCardForAnimal(Long animalId){
        idCardRepository.deleteById(animalId);
    }

}
