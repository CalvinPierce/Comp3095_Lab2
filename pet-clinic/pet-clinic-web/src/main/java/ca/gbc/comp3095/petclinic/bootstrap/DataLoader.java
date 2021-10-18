package ca.gbc.comp3095.petclinic.bootstrap;

import ca.gbc.comp3095.petclinic.model.Owner;
import ca.gbc.comp3095.petclinic.model.Vet;
import ca.gbc.comp3095.petclinic.services.OwnerService;
import ca.gbc.comp3095.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Bruce");
        owner1.setLastName("Wayne");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Peter");
        owner2.setLastName("Parker");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Diana");
        vet1.setLastName("Prince");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bruce");
        vet2.setLastName("Banner");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
