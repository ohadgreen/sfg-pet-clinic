package com.acme.sfgpetclinic.bootstrap;

import com.acme.sfgpetclinic.model.Owner;
import com.acme.sfgpetclinic.model.Vet;
import com.acme.sfgpetclinic.services.OwnerService;
import com.acme.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDataLoader implements CommandLineRunner {// this will be triggered once the app is started
    private final OwnerService ownerService;
    private final VetService vetService;

    public InitDataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner("Alice", "Cooper");
        Owner owner2 = new Owner("Bon", "Jovi");

        System.out.println("saving alice...");
        ownerService.save(owner1);
        System.out.println("saving bon...");
        ownerService.save(owner2);
        System.out.println("Loaded Owners to map");

        Vet vet1 = new Vet("Eran", "Binyamini");
        Vet vet2 = new Vet("Doctor", "Doolittle");

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Loaded Vets to map");

    }
}
