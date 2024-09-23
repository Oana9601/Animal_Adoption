package ro.animals_adoption_center.adoption.mapper;

import org.springframework.stereotype.Component;
import ro.animals_adoption_center.adoption.dto.AdoptionCenterDTO;
import ro.animals_adoption_center.adoption.model.AdoptionCenter;

@Component
public class AdoptionCenterMapper {

    public static AdoptionCenterDTO toDTO(AdoptionCenter adoptionCenter) {
        AdoptionCenterDTO dto = new AdoptionCenterDTO();

        dto.setCenterName(adoptionCenter.getCenterName());
        dto.setAddress(adoptionCenter.getAddress());

        return dto;

    }

    public static AdoptionCenter toEntity(AdoptionCenterDTO adoptionCenterDTO) {
        AdoptionCenter adoptionCenter = new AdoptionCenter();

        adoptionCenter.setAddress(adoptionCenterDTO.getAddress());
        adoptionCenter.setCenterName(adoptionCenterDTO.getCenterName());

        return adoptionCenter;

    }
}
