package ca.gbc.comp3095.petclinic.repositories;

import ca.gbc.comp3095.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
