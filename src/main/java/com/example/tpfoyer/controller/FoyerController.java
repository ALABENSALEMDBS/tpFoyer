package com.example.tpfoyer.controller;

import com.example.tpfoyer.entities.Foyer;
import com.example.tpfoyer.services.IFoyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("foyer")

public class FoyerController {
    IFoyerService foyerService;

    // http://localhost:8089/tpfoyer/foyer/retrieve-all-foyer
    @Operation(description = "récupérer toutes les foyers de la base de données ")
    @GetMapping("/retrieve-all-foyer")
    public List<Foyer> retrieveAllFoyer() {
        List<Foyer> listefoyers = foyerService.getAllFoyers();
        return listefoyers;
    }

    // http://localhost:8089/tpfoyer/foyer/retrieve-foyer/{Foyer-id}
    @Operation(description = "récupérer un foyer par id de la base de données")
    @GetMapping("/retrieve-foyer/{Foyer-id}")
    public Foyer retrieveFoyer(@PathVariable ("Foyer-id") Long idFoyer) {
        Foyer foyer = foyerService.getFoyerById(idFoyer);
        return foyer;
    }


    // http://localhost:8089/tpfoyer/foyer/add-foyer
    @Operation(description = "ajouter un foyer dans la base de données")
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foy) {
        Foyer foyer = foyerService.addFoyer(foy);
        return foyer;
    }


    // http://localhost:8089/tpfoyer/foyer/remove-foyer/{Foyer-id}
    @Operation(description = "supprimer un foyer par id de la base de données")
    @DeleteMapping("/remove-foyer/{Foyer-id}")
    public void removeFoyer(@PathVariable ("Foyer-id") Long idFoyer) {
        foyerService.deleteFoyer(idFoyer);
    }


    // http://localhost:8089/tpfoyer/foyer/modify-foyer
    @Operation(description = "modifier un foyer de la base de données")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer foy) {
        Foyer foyer = foyerService.modifyFoyer(foy);
        return foyer;
    }

}
