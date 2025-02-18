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
public class Etudiant {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idEtudiant;

    String nomEt;

    String prenomEt;

    Long cin;

    String ecole;

    Date dateNaissance;
@JsonIgnore
    @ManyToMany (mappedBy = "etudiants")
    Set<Reservation> reservations;
}
