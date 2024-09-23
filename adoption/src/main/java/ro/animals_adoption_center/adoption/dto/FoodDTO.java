package ro.animals_adoption_center.adoption.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    @NotBlank(message = "Species is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String species;

    @NotBlank(message = "Brand is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private  String brand;

}
