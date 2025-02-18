package com.example.tpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    String idReservation;

    Date anneeUniversitaire;

    boolean estValide;

    //@JsonIgnore
    @ManyToMany
    Set<Etudiant> etudiants;
}
