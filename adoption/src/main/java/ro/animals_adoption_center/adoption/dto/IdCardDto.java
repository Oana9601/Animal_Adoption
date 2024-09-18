package ro.animals_adoption_center.adoption.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.animals_adoption_center.adoption.model.Animal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdCardDto {

    @NotBlank(message = "AnimalSex is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String animalSex;

    @NotBlank(message = "Series is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private  String series;

    @NotNull(message = "Age is mandatory")
    private Integer age;

    @NotBlank(message = "Species is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String species;

    @NotBlank(message = "Breed is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String breed;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 350, message = "Max size no more than 350 characters")
    private String description;

}
