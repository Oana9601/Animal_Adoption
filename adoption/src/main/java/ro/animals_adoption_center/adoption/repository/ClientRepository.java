package ro.animals_adoption_center.adoption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.animals_adoption_center.adoption.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
