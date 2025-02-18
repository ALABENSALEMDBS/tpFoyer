package com.example.tpfoyer.controller;

import com.example.tpfoyer.entities.Foyer;
import com.example.tpfoyer.entities.Reservation;
import com.example.tpfoyer.services.IReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Gestion Reservation")
@AllArgsConstructor
@RestController
@RequestMapping("reservation")
public class ReservationController {
    IReservationService reservationService;

    // http://localhost:8089/tpfoyer/reservation/retrieve-all-reservation
    @Operation(description = "récupérer toutes les reservation de la base de données ")
    @GetMapping("/retrieve-all-reservation")
    public List<Reservation> retrieveAllReservation() {
        List<Reservation> listereservations = reservationService.getAllReservations();
        return listereservations;
    }

    // http://localhost:8089/tpfoyer/reservation/retrieve-reservation/{Reservation-id}
    @Operation(description = "récupérer un reservation par id de la base de données")
    @GetMapping("/retrieve-reservation/{Reservation-id}")
    public Reservation retrieveReservation(@PathVariable("Reservation-id") String idReservation) {
        Reservation reservation = reservationService.getReservationById(idReservation);
        return reservation;
    }

    // http://localhost:8089/tpfoyer/reservation/add-reservation
    @Operation(description = "ajouter un reservation dans la base de données")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reser) {
        Reservation reservation = reservationService.addReservation(reser);
        return reservation;
    }

    // http://localhost:8089/tpfoyer/reservation/remove-reservation/{Reservation-id}
    @Operation(description = "supprimer un reservation par id dans la base de données")
    @DeleteMapping ("/remove-reservation/{Reservation-id}")
    public void removeReservation(@PathVariable("Reservation-id") String idReservation) {
        reservationService.deleteReservation(idReservation);
    }

    // http://localhost:8089/tpfoyer/reservation/modify-reservation
    @Operation(description = "modifier un reservation dans la base de données")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reser) {
        Reservation reservation = reservationService.modifyReservation(reser);
        return reservation;
    }
}
