package ca.gbc.comp3095.petclinic.model.repositories;

import ca.gbc.comp3095.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);
}
