package com.example.tpfoyer.controller;

import com.example.tpfoyer.entities.Chambre;
import com.example.tpfoyer.entities.TypeChambre;
import com.example.tpfoyer.services.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Chambre")
@RestController
@AllArgsConstructor
@RequestMapping("chambre")
public class ChambreController {
    IChambreService chambreService;

    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.getAllChambre();
        return listChambres;
    }

    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/{chambre-id}
    @Operation(description = "récupérer un chambre par id de la base de données")
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long idChambre) {
        Chambre chambre = chambreService.retrieveChambre(idChambre);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @Operation(description = "ajouter un nouveau chambre au base de données")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @Operation(description = "supprimer un chambre de la base de données")
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long idChambre) {
        chambreService.deleteChambre(idChambre);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @Operation(description = "modifier un chambre de la base de données")
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/chambrebytype
    @GetMapping("/chambrebytype/{type}")
    public List<Chambre> chambreByType(@PathVariable("type") TypeChambre typeChambre) {
        return chambreService.findAllByTypeC(typeChambre);
    }


    // http://localhost:8089/tpfoyer/chambre/chambrebynumero
    @GetMapping("/chambrebynumero/{numero}")
    public Chambre chambreByNumero(@PathVariable("numero") Long numero) {
        return chambreService.findChambreByNumeroChambre(numero);
    }



    // http://localhost:8089/tpfoyer/chambre/findChambreByEtudiantCin
    @GetMapping("/findChambreByEtudiantCin/{cin}")
    public Chambre chambreByEtudiantCin(@PathVariable("cin") Long cin) {
        return chambreService.findChambreByEtudiantCin(cin);
    }



}
