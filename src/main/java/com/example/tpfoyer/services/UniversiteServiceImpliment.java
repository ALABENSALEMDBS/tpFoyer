package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Foyer;
import com.example.tpfoyer.entities.Universite;
import com.example.tpfoyer.repository.FoyerRepository;
import com.example.tpfoyer.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpliment implements IuniversiteService{

    UniversiteRepository universiteRepository;
    FoyerRepository foyerRepository;

    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    public Universite modifyUniversite(Universite universite) {

      return universiteRepository.save(universite);
    }

    public void deleteUniversite(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);

    }

    public List<Universite> getAllUniversites() {
        List<Universite> universites = universiteRepository.findAll();
        return universites;
    }

    public Universite getUniversiteById(Long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    public Universite affecterFoyerToUniversity(Universite universite, Long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer).get();
        universite.setFoyer(foyer);
        return universiteRepository.save(universite) ;
    }
}
