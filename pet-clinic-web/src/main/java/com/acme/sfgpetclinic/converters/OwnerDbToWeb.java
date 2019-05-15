package com.acme.sfgpetclinic.converters;

import com.acme.sfgpetclinic.model.Owner;
import com.acme.sfgpetclinic.model.OwnerWeb;
import com.acme.sfgpetclinic.model.PetWeb;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class OwnerDbToWeb implements Converter<Owner, OwnerWeb> {
    private final PetDbToWeb petDbToWeb;

    public OwnerDbToWeb(PetDbToWeb petDbToWeb) {
        this.petDbToWeb = petDbToWeb;
    }

    @Override
    public OwnerWeb convert(Owner owner) {
        OwnerWeb ownerWeb = new OwnerWeb();
        ownerWeb.setFirstName(owner.getFirstName());
        ownerWeb.setLastName(owner.getLastName());
        ownerWeb.setAddress(owner.getAddress());
        ownerWeb.setCity(owner.getCity());
        Set<PetWeb> petWebSet = new HashSet<>();
        owner.getPets().forEach(pet -> petWebSet.add(petDbToWeb.convert(pet)));
        ownerWeb.setPets(petWebSet);
        return ownerWeb;
    }
}
