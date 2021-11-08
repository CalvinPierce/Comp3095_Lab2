package ca.gbc.comp3095.petclinic.bootstrap;

import ca.gbc.comp3095.petclinic.model.*;
import ca.gbc.comp3095.petclinic.services.OwnerService;
import ca.gbc.comp3095.petclinic.services.PetTypeService;
import ca.gbc.comp3095.petclinic.services.SpecialtyService;
import ca.gbc.comp3095.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0){
            loadData();
        }
    }

    private void loadData(){
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty savedDentistry = specialtyService.save(dentistry);
        Specialty savedSurgery = specialtyService.save(surgery);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType dogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType catPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Bruce");
        owner1.setLastName("Wayne");
        owner1.setAddress("123 Some St");
        owner1.setTelephone("123-456-7890");
        owner1.setCity("Gotham");

        Pet brucesPet = new Pet();
        brucesPet.setName("Fido");
        brucesPet.setPetType(dogPetType);
        brucesPet.setOwner(owner1);
        owner1.getPets().add(brucesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Peter");
        owner2.setLastName("Parker");
        owner2.setAddress("321 Spider St");
        owner2.setTelephone("098-765-4321");
        owner2.setCity("New York");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Diana");
        vet1.setLastName("Prince");
        vet1.getSpecialties().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bruce");
        vet2.setLastName("Banner");
        vet2.getSpecialties().add(surgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
