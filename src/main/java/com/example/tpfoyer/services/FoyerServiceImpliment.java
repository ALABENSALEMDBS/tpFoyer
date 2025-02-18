package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Foyer;
import com.example.tpfoyer.repository.FoyerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpliment implements IFoyerService {

    FoyerRepository foyerRepository;

    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public void deleteFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public List<Foyer> getAllFoyers() {
        List<Foyer> foyers = foyerRepository.findAll();
        return foyers;
    }

    public Foyer getFoyerById(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }
}
