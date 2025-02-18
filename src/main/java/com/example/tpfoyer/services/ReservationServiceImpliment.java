package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Reservation;
import com.example.tpfoyer.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpliment implements IReservationService{

    ReservationRepository reservationRepository;


    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(String idReservation) {
       reservationRepository.deleteById(idReservation);
    }

    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    public Reservation getReservationById(String idReservation) {
        return reservationRepository.findById(idReservation).get();
    }
}
