package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Etudiant;
import com.example.tpfoyer.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpliment implements IEtudiantService{

    EtudiantRepository etudiantRepository;

    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);

    }

    public Etudiant modifyEtudiant(Etudiant etudiant) {
        //ajouter une code pour verife et afficher avant save

        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return etudiants;
    }

    public Etudiant getEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }
}
