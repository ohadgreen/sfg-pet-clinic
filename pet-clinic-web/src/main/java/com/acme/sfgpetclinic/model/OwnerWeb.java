package com.acme.sfgpetclinic.model;


import java.util.HashSet;
import java.util.Set;

public class OwnerWeb {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<PetWeb> getPets() {
        return pets;
    }

    public void setPets(Set<PetWeb> pets) {
        this.pets = pets;
    }

    private String address;
    private String city;
    private String telephone;
    private Set<PetWeb> pets = new HashSet<>();
}
