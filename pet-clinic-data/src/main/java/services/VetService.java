package services;

import model.Pet;
import model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Pet vet);

    Set<Vet> findAll();
}
