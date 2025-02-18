package com.example.tpfoyer.controller;


import com.example.tpfoyer.entities.Bloc;
import com.example.tpfoyer.entities.Chambre;
import com.example.tpfoyer.services.IBlocService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Bloc")
@RestController
@AllArgsConstructor
@RequestMapping("bloc")
public class BlocController {
    IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @Operation(description = "récupérer toutes les blocs de la base de données")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listblocs=blocService.getAllBlocs();
        return listblocs;
    }

    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/{bloc-id}
    @Operation(description = "récupérer un bloc par ID de la base de données")
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long idBloc) {
        Bloc bloc = blocService.getBlocById(idBloc);
        return bloc;
    }

   // http://localhost:8089/tpfoyer/bloc/add-bloc
   @Operation(description = "ajouter un nouveau bloc au base de données")
   @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @Operation(description = "modifier un bloc de la base de données")
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.modifyBloc(b);
        return bloc;
    }

    // http://localhost:8089/tpfoyer/bloc/remove-bloc/{bloc-id}
    @Operation(description = "supprimer un bloc de la base de données")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long idBloc) {
        blocService.deleteBloc(idBloc);
    }



    //http://localhost:8089/tpfoyer/bloc/affecter-bloc-a-foyer/1/1
    @PutMapping("/affecter-bloc-a-foyer/{bloc-id}/{foyer-id}")
    public void assignFoyerToBloc(@PathVariable("bloc-id") Long idBloc, @PathVariable("foyer-id") Long idFoyer) {
        blocService.assignFoyerToBloc(idBloc, idFoyer);
    }


    //http://localhost:8089/tpfoyer/bloc/desaffecter-bloc-a-foyer/12
    @PutMapping("/desaffecter-bloc-a-foyer/{id-bloc}")
    public Bloc DesaffecterFoyerFromBloc(@PathVariable("id-bloc") Long idBloc) {
        return blocService.DesaffecterFoyerFromBloc(idBloc);
    }


    //http://localhost:8089/tpfoyer/bloc/findAllBlocByFoyerIsNull
    @GetMapping("/findAllBlocByFoyerIsNull")
    public List<Bloc> findAllBlocByFoyerIsNull() {
        return blocService.findAllByFoyerIsNull();
    }


}

