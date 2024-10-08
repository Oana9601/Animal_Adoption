package ro.animals_adoption_center.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.animals_adoption_center.adoption.model.IdCard;

import java.util.Optional;

@Repository
public interface IdCardRepository extends JpaRepository<IdCard, Long> {

    @Query(value="SELECT * FROM id_cards WHERE animal_id = ?1", nativeQuery= true)
    Optional<IdCard> findByAnimalId(Long animalId);

}