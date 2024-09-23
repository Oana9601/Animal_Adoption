package ro.animals_adoption_center.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.animals_adoption_center.adoption.model.AdoptionCenter;
import ro.animals_adoption_center.adoption.model.IdCard;

import java.util.Optional;

@Repository
public interface AdoptionCenterRepository  extends JpaRepository<AdoptionCenter, Long> {

    @Query(value="SELECT * FROM adoptions WHERE animal_id = ?1", nativeQuery= true)
    Optional<AdoptionCenter> findByAnimalId(Long animalId);

}
