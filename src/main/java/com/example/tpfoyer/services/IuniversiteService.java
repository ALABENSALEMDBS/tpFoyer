package com.example.tpfoyer.services;


import com.example.tpfoyer.entities.Universite;

import java.util.List;

public interface IuniversiteService {
    Universite addUniversite(Universite universite);
    Universite modifyUniversite(Universite universite);
    void deleteUniversite(Long idUniversite);
    List<Universite> getAllUniversites();
    Universite getUniversiteById(Long idUniversite);

    Universite affecterFoyerToUniversity(Universite universite, Long idFoyer);
}
