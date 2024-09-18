package ro.animals_adoption_center.adoption.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "id_card")
public class IdCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, name = "series")
    private  String series;

    @Column(nullable = false, length = 50, name = "animal_sex")
    private String animalSex;

    @Column(nullable = false, name = "age")
    private Integer age;

    @Column(nullable = false, length = 50, name = "species")
    private String species;

    @Column(nullable = false, length = 50, name = "breed")
    private String breed;

    @Column(nullable = false, length = 350)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;


}
