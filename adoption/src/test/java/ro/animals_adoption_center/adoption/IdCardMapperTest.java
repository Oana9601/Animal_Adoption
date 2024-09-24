package ro.animals_adoption_center.adoption;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ro.animals_adoption_center.adoption.dto.IdCardDto;
import ro.animals_adoption_center.adoption.mapper.IdCardMapper;
import ro.animals_adoption_center.adoption.model.Animal;
import ro.animals_adoption_center.adoption.model.IdCard;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IdCardMapperTest {

    @Test
    void toDTO() {
        IdCard idCard = new IdCard();
        idCard.setDescription("Cat");
        idCard.setAnimalSex("female");
        idCard.setSeries("123456");
        idCard.setAge(23);
        idCard.setBreed("bermanise");
        idCard.setAnimal(new Animal());
        idCard.setSpecies("cat");

        IdCardDto dto =new IdCardDto();
        dto.setSeries("123456");
        dto.setBreed("bermanise");
        dto.setAnimalSex("female");
        dto.setSpecies("cat");
        dto.setAge(23);
        dto.setDescription("Cat");

        assertEquals(dto, IdCardMapper.toDTO(idCard));
    }

    @Test
    void toEntity() {
        IdCard idCard = new IdCard();
        idCard.setDescription("Cat");
        idCard.setAnimalSex("female");
        idCard.setSeries("123456");
        idCard.setAge(23);
        idCard.setBreed("bermanise");
        idCard.setSpecies("cat");

        IdCardDto dto = new IdCardDto();
        dto.setSeries("123456");
        dto.setBreed("bermanise");
        dto.setAnimalSex("female");
        dto.setSpecies("cat");
        dto.setAge(23);
        dto.setDescription("Cat");

        assertEquals(idCard, IdCardMapper.toEntity(dto));
    }
}
