package com.acme.sfgpetclinic.bootstrap;

import model.Owner;
import model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.Map.OwnerServiceMap;
import services.Map.VetServiceMap;
import services.OwnerService;
import services.VetService;

@Component
public class InitDataLoader implements CommandLineRunner {// this will be triggered once the app is started
    private final OwnerService ownerService;
    private final VetService vetService;

    public InitDataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner("Alice", "Cooper");
        owner1.setId(1L);
        Owner owner2 = new Owner("Bon", "Jovi");
        owner2.setId(2L);

        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Loaded Owners to map");

        Vet vet1 = new Vet("Eran", "Binyamini");
        vet1.setId(11L);
        Vet vet2 = new Vet("Doctor", "Doolittle");
        vet2.setId(12L);

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded Vets to map");

    }
}
