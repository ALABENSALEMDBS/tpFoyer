package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService{

    Etudiant addEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long idEtudiant);
    Etudiant modifyEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long idEtudiant);
}
