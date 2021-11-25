package ca.gbc.comp3095.petclinic.model.repositories;

import ca.gbc.comp3095.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
