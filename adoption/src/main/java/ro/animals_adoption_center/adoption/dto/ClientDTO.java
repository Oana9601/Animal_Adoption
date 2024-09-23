package ro.animals_adoption_center.adoption.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Size(max = 50, message = "Maximum size no more than 50 characters")
    private String email;


}
