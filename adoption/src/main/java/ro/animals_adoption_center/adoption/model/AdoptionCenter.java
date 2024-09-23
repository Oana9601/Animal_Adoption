package ro.animals_adoption_center.adoption.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adoptions")
public class AdoptionCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdoptionCenter;

    @Column(nullable = false, length = 50, name = "center_name")
    private  String centerName;

    @Column(nullable = false, length = 50, name = "address")
    private  String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id", referencedColumnName = "id")
    private Animal animal;


}
