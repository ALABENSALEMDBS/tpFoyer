package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Chambre;
import com.example.tpfoyer.entities.TypeChambre;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IChambreService {
    public Chambre addChambre(Chambre chambre);
    void deleteChambre(Long idChambre);
    Chambre modifyChambre(Chambre chambre);
    List<Chambre> getAllChambre();
    Chambre retrieveChambre(Long idChambre);
    List<Chambre> findAllByTypeC(TypeChambre tc);
    Chambre findChambreByNumeroChambre(long numC);

    Chambre findChambreByEtudiantCin(Long cin);


    public void listeChambresParBloc();

    public void pourcentageChambreParTypeChambre();

}
