package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc bloc);
    void deleteBloc(Long idBloc);
    Bloc modifyBloc(Bloc bloc);
    List<Bloc> getAllBlocs();
    Bloc getBlocById(Long idBloc);
    void assignFoyerToBloc(Long idBloc , Long idFoyer);

    Bloc DesaffecterFoyerFromBloc(Long idBloc);

    List<Bloc> findAllByFoyerIsNull();
}
