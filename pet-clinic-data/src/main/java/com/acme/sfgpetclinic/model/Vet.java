package com.acme.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {
    private Set<Specialty> specialties;

    public Vet(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
