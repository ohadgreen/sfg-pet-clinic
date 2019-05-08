package com.acme.sfgpetclinic.services.Map;

import com.acme.sfgpetclinic.model.Vet;
import org.springframework.stereotype.Service;
import com.acme.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet pet) {
        super.delete(pet);

    }

    @Override
    public Vet save(Vet pet) {
        return super.save(pet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
