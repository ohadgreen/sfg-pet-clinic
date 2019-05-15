package com.acme.sfgpetclinic.converters;

import com.acme.sfgpetclinic.model.Pet;
import com.acme.sfgpetclinic.model.PetWeb;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PetDbToWeb implements Converter<Pet, PetWeb> {
    @Override
    public PetWeb convert(Pet pet) {
        PetWeb petWeb = new PetWeb();
        petWeb.setName(pet.getName());
        petWeb.setPetType(pet.getPetType().getName());
        petWeb.setBirthDate(pet.getBirthDate());
        petWeb.setOwnerFirstName(pet.getOwner().getFirstName());
        petWeb.setOwnerLastName(pet.getOwner().getLastName());
        return petWeb;
    }
}
