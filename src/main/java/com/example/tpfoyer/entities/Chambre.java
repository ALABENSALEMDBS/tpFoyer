package com.example.tpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)
public class Chambre {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idChambre;

    Long numeroChambre;

    @Enumerated (EnumType.STRING)
    TypeChambre typeC;
@JsonIgnore
    @ManyToOne
    Bloc bloc;
  //@JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    Set<Reservation> reservations = new HashSet<>();
}
