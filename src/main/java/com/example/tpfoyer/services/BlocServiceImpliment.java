package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Bloc;
import com.example.tpfoyer.entities.Foyer;
import com.example.tpfoyer.repository.BlocRepository;
import com.example.tpfoyer.repository.FoyerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class BlocServiceImpliment implements IBlocService{
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;

    public Bloc addBloc(Bloc bloc) {

        return blocRepository.save(bloc);
    }

    public void deleteBloc(Long idBloc) {

        blocRepository.deleteById(idBloc);
    }

    public Bloc modifyBloc(Bloc bloc) {

            return blocRepository.save(bloc);

    }

    //@Scheduled(cron = "0 0/5 5 * 1 3")
    public List<Bloc> getAllBlocs() {
        List<Bloc> blocs = blocRepository.findAll();
        for (Bloc bloc : blocs) {
            log.info("BLOC"+bloc);
        }
        return blocs;
    }

    public Bloc getBlocById(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    public void assignFoyerToBloc(Long idBloc, Long idFoyer) {
          Foyer foyer = foyerRepository.findById(idFoyer).get();
          Bloc bloc = blocRepository.findById(idBloc).get();
        // on set le fils dans le parent
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
    }

    public Bloc DesaffecterFoyerFromBloc(Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).get();
        bloc.setFoyer(null);
        return blocRepository.save(bloc);
    }

    public List<Bloc> findAllByFoyerIsNull() {
        return blocRepository.findAllByFoyerIsNull();
    }


}


/*

public Bloc modifyBloc(Bloc bloc, Long idBloc) {
        if (blocRepository.existsById(idBloc)) {
            Bloc existingBloc = blocRepository.findById(idBloc).get();
            existingBloc.setCapaciteBloc(existingBloc.getCapaciteBloc() + 1);
            return blocRepository.save(existingBloc);
        } else {
            throw new RuntimeException("Bloc avec ID " + idBloc + " non trouvé");
        }

    }
 */