package com.example.tpfoyer.repository;

import com.example.tpfoyer.entities.Chambre;
import com.example.tpfoyer.entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    List<Chambre> findAllByTypeC(TypeChambre tc);
    Chambre findChambreByNumeroChambre(long numC);


    @Query("SELECT c FROM Chambre c " +
            "JOIN c.reservations r " +
            "JOIN r.etudiants e " +
            "WHERE e.cin = :cin")
    Chambre findChambreByEtudiantCin(@Param("cin") Long cin);


}
