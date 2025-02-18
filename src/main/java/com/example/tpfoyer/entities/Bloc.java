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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bloc {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Long idBloc;

    String nomBloc;

    Long capaciteBloc;


    @ManyToOne(cascade = CascadeType.ALL)
    Foyer foyer;

 @JsonIgnore
    @OneToMany (mappedBy = "bloc", fetch = FetchType.EAGER)
    Set <Chambre> chambres =new HashSet<>();
}

//testttttttttttttttttttttttttttt
