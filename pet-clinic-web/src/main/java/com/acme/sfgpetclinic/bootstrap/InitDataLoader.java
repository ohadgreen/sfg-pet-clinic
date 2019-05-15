package com.acme.sfgpetclinic.bootstrap;

import com.acme.sfgpetclinic.model.Owner;
import com.acme.sfgpetclinic.model.Pet;
import com.acme.sfgpetclinic.model.PetType;
import com.acme.sfgpetclinic.model.Vet;
import com.acme.sfgpetclinic.services.OwnerService;
import com.acme.sfgpetclinic.services.PetTypeService;
import com.acme.sfgpetclinic.services.VetService;
import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitDataLoader implements CommandLineRunner {// this will be triggered once the app is started
    private static final Logger logger = LoggerFactory.getLogger(InitDataLoader.class);
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public InitDataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner("Alice", "Cooper");
        owner1.setAddress("Acme St. 1");
        owner1.setCity("New York City");
        owner1.setTelephone("12345678");

        Owner owner2 = new Owner("Bon", "Jovi");
        owner2.setAddress("Acme St. 2");
        owner2.setCity("Hertzlia");
        owner2.setTelephone("67890");

        Pet aliceCat = new Pet();
        aliceCat.setPetType(savedCatType);
        aliceCat.setName("Fiona");
        aliceCat.setBirthDate(LocalDate.now());
        aliceCat.setOwner(owner1);

        Pet bonDog = new Pet();
        bonDog.setPetType(savedDogType);
        bonDog.setName("Shrek");
        bonDog.setBirthDate(LocalDate.now());
        bonDog.setOwner(owner2);

        Set<Pet> alicePetSet = new HashSet<>();
        alicePetSet.add(aliceCat);
        owner1.setPets(alicePetSet);

        Set<Pet> bonPetSet = new HashSet<>();
        bonPetSet.add(bonDog);
        owner2.setPets(bonPetSet);

        ownerService.save(owner1);
        ownerService.save(owner2);
        logger.info("Loaded Owners to map");

        Vet vet1 = new Vet("Eran", "Binyamini");
        Vet vet2 = new Vet("Doctor", "Doolittle");

        vetService.save(vet1);
        vetService.save(vet2);
        logger.info("Loaded Vets to map");
        logger.info("Loaded PetTypes to map");
    }
}
