package com.example.tpfoyer.controller;

import com.example.tpfoyer.entities.Etudiant;
import com.example.tpfoyer.services.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Etudient")
@RestController
@AllArgsConstructor
@RequestMapping("etudient")
public class EtudientController {
    IEtudiantService etudiantService;


    // http://localhost:8089/tpfoyer/etudient/retrieve-all-etudient
    @Operation(description = "récupérer toutes les etudient de la base de données")
    @GetMapping("/retrieve-all-etudient")
    public List<Etudiant> retrieveAllEtudiant() {
        List<Etudiant> listeEtudients = etudiantService.getAllEtudiants();
        return listeEtudients;
    }


    // http://localhost:8089/tpfoyer/etudient/retrieve-etudient/{Etudient-id}
    @Operation(description = "récupérer un edutient par id de la base de données")
    @GetMapping("/retrieve-etudient/{Etudient-id}")
    public Etudiant retrieveEtudient(@PathVariable ("Etudient-id") Long idEtudient) {
        Etudiant etudiant = etudiantService.getEtudiantById(idEtudient);
        return etudiant;
    }

    // http://localhost:8089/tpfoyer/etudient/add-etudient
    @Operation(description = "ajouter un etudient dans la base de données")
    @PostMapping("/add-etudient")
    public Etudiant addEtudient(@RequestBody Etudiant etu) {
        Etudiant etudiant = etudiantService.addEtudiant(etu);
        return etudiant;
    }

    // http://localhost:8089/tpfoyer/etudient/remove-etudient/{etudient-id}
    @Operation(description = "supprimer un etudient de la base de données")
    @DeleteMapping("/remove-etudient/{etudient-id}")
    public void removeEtudient(@PathVariable ("etudient-id") Long idEtudient) {
        etudiantService.deleteEtudiant(idEtudient);
    }


    // http://localhost:8089/tpfoyer/etudient/modify-etudient
    @Operation(description = "modifier un etudient de la base de données")
    @PutMapping("/modify-etudient")
    public Etudiant modifyEtudient(@RequestBody Etudiant etu) {
        Etudiant etudiant = etudiantService.modifyEtudiant(etu);
        return etudiant;
    }


}
