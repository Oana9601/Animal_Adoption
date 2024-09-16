package ro.animals_adoption_center.adoption.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adoption")
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdoption;

    @Column(nullable = false, name = "animal_id")
    private Long animalID;

    @Column(nullable = false, name = "master_id")
    private Long masterID;

    @Column(nullable = false, name = "date_adoption")
    private LocalDateTime dateAdoption;

    @Column(nullable = false, length = 50, name = "master_name")
    private String masterName;

}
