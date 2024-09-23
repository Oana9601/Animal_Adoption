package ro.animals_adoption_center.adoption.mapper;

import org.springframework.stereotype.Component;
import ro.animals_adoption_center.adoption.dto.IdCardDto;
import ro.animals_adoption_center.adoption.model.IdCard;

@Component
public class IdCardMapper {
    public static IdCardDto toDTO(IdCard idCard) {
        IdCardDto dto = new IdCardDto();
        dto.setAnimalSex(idCard.getAnimalSex());
        dto.setSpecies(idCard.getSpecies());
        dto.setAge(idCard.getAge());
        dto.setBreed(idCard.getBreed());
        dto.setDescription(idCard.getDescription());
        dto.setSeries(idCard.getSeries());

        return dto;
    }

    public static IdCard toEntity(IdCardDto idCardDto) {
        IdCard idCard = new IdCard();
        idCard.setAnimalSex(idCardDto.getAnimalSex());
        idCard.setSpecies(idCardDto.getSpecies());
        idCard.setAge(idCardDto.getAge());
        idCard.setBreed(idCardDto.getBreed());
        idCard.setDescription(idCardDto.getDescription());
        idCard.setSeries(idCardDto.getSeries());

        return idCard;
    }
}
