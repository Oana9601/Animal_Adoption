package ro.animals_adoption_center.adoption.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Animal> animalList;


}
