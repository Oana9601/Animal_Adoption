package ro.animals_adoption_center.adoption.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.animals_adoption_center.adoption.model.IdCard;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {


    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String name;

    @NotBlank(message = "Species is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String species;

    @NotNull(message = "Age is mandatory")
    private Integer age;

    @NotBlank(message = "Breed is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String breed;

    @NotBlank(message = "Description is mandatory")
    @Size(max = 350, message = "Max size no more than 350 characters")
    private String description;

    @NotNull(message = "Available status is mandatory")
    private Boolean available;


}

