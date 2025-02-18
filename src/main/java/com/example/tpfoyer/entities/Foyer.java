package com.example.tpfoyer.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFoyer;

    String nomFoyer;

    Long capaciteFoyer;

    @JsonIgnore
    @OneToOne (mappedBy = "foyer")
    Universite universite;


    @OneToMany (mappedBy = "foyer")
    @JsonIgnore
    @ToStringExclude
    Set <Bloc> blocs;
}
