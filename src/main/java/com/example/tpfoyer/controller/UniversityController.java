package com.example.tpfoyer.controller;


import com.example.tpfoyer.entities.Universite;
import com.example.tpfoyer.services.IuniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion University")
@AllArgsConstructor
@RestController
@RequestMapping("university")
public class UniversityController {
    IuniversiteService universiteService;

    // http://localhost:8089/tpfoyer/university/retrieve-all-university
    @Operation(description = "récupérer toutes les universitées de la base de données ")
    @GetMapping("/retrieve-all-university")
    public List<Universite> retrieveAllUniversity() {
        List<Universite> listeUniversites = universiteService.getAllUniversites();
        return listeUniversites;
    }

    // http://localhost:8089/tpfoyer/university/retrieve-university/{University-id}
    @Operation(description = "récupérer un university par id de la base de données")
    @GetMapping("/retrieve-university/{University-id}")
    public Universite retrieveUniversity(@PathVariable ("University-id") Long idUniversity) {
        Universite universite = universiteService.getUniversiteById(idUniversity);
        return universite;
    }


    // http://localhost:8089/tpfoyer/university/add-university
    @Operation(description = "ajouter un university dans la base de données")
    @PostMapping("/add-university")
    public Universite addUniversity(@RequestBody Universite univer) {
        Universite universite = universiteService.addUniversite(univer);
        return universite;
    }

    // http://localhost:8089/tpfoyer/university/remove-university/{University-id}
    @Operation(description = "supprimer un university par id dans la base de données")
    @DeleteMapping ("/remove-university/{University-id}")
    public void removeUniversity(@PathVariable ("University-id") Long idUniversity) {
        universiteService.deleteUniversite(idUniversity);
    }

    // http://localhost:8089/tpfoyer/university/modify-university
    @Operation(description = "modifier un university dans la base de données")
    @PutMapping("/modify-university")
    public Universite modifyUniversity(@RequestBody Universite univer) {
        Universite universite = universiteService.modifyUniversite(univer);
        return universite;
    }



    // http://localhost:8089/tpfoyer/university/affectUniToFoy/{{idF}}
    @PostMapping("/affectUniToFoy/{idF}")
    public Universite affectUniToFoy(@PathVariable ("idF") Long idFoyer, @RequestBody Universite univer) {
        return universiteService.affecterFoyerToUniversity(univer, idFoyer);
    }
}
