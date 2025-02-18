package com.example.tpfoyer.services;

import com.example.tpfoyer.entities.Chambre;
import com.example.tpfoyer.entities.TypeChambre;
import com.example.tpfoyer.repository.ChambreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class ChambreServiceImpliment implements IChambreService{

    ChambreRepository chambreRepository;

    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public void deleteChambre(Long idChambre) {
      chambreRepository.deleteById(idChambre);
    }

    public Chambre modifyChambre(Chambre chambre) {
        //ajouter une code pour verife et afficher avant save
        return chambreRepository.save(chambre);
    }

    //@Scheduled(cron = "*/20 * * * * *")
    public List<Chambre> getAllChambre() {
        List<Chambre> chambres = chambreRepository.findAll();
//        for (Chambre chambre : chambres) {
//            System.out.println(chambre);
//            log.info("chambre: " +chambre);
//        }
        return chambres;
    }


    public Chambre retrieveChambre(Long idChambre)
    {
        return chambreRepository.findById(idChambre).get();
    }

    public List<Chambre> findAllByTypeC(TypeChambre tc) {
        return chambreRepository.findAllByTypeC(tc);
    }

    public Chambre findChambreByNumeroChambre(long numC) {
        return chambreRepository.findChambreByNumeroChambre(numC);
    }

    public Chambre findChambreByEtudiantCin(Long cin) {
        return chambreRepository.findChambreByEtudiantCin(cin);
    }


    @Scheduled(cron = "0 0 * * * *" )
    public void listeChambresParBloc() {
        List<Chambre> chambres = chambreRepository.findAll();
        for (Chambre chambre : chambres) {
            log.info("Bloc => " +chambre.getBloc().getNomBloc()+" ayant une capacité "+ chambre.getBloc().getCapaciteBloc());
            log.info("La liste des chambres pour ce bloc: ");
            log.info("NumChambre: " + chambre.getIdChambre() + " type: " + chambre.getTypeC());
            log.info("***************************");
        }
    }

    @Scheduled(cron = "0 */5 * * * *")
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepository.findAll();

        int totalChambres = chambres.size();
        log.info("Nombre total des chambres: " + totalChambres);

        if (totalChambres == 0) {
            log.info("Aucune chambre n'est disponible.");
            return;
        }

        int simpleCount = 0;
        int doubleCount = 0;
        int tripleCount = 0;

        for (Chambre chambre : chambres) {
            TypeChambre type = chambre.getTypeC();
            if (type == TypeChambre.SIMPLE) {
                simpleCount++;
            } else if (type == TypeChambre.DOUBLE) {
                doubleCount++;
            } else if (type == TypeChambre.TRIPLE) {
                tripleCount++;
            }
        }

        double simplePourcentage = (simpleCount * 100.0) / totalChambres;
        double doublePourcentage = (doubleCount * 100.0) / totalChambres;
        double triplePourcentage = (tripleCount * 100.0) / totalChambres;

        log.info("Le pourcentage des chambres pour le type SIMPLE est égale à " + String.format("%.1f", simplePourcentage));
        log.info("Le pourcentage des chambres pour le type DOUBLE est égale à " + String.format("%.1f", doublePourcentage));
        log.info("Le pourcentage des chambres pour le type TRIPLE est égale à " + String.format("%.1f", triplePourcentage));
    }


//    @Scheduled(cron = "0 */5 * * * *")
//    public void pourcentageChambreParTypeChambre() {
//        List<Chambre> chambres = chambreRepository.findAll();
//
//        int totalChambres = chambres.size();
//        log.info("Nombre total des chambres: " + totalChambres);
//
//
//        if (totalChambres == 0) {
//            log.info("Aucune chambre n'est disponible.");
//            return;
//        }
//
//        Map<TypeChambre, Integer> chambresParType = new HashMap<>();
//
//        for (Chambre chambre : chambres) {
//            TypeChambre type = chambre.getTypeC();
//            chambresParType.put(type, chambresParType.getOrDefault(type, 0) + 1);
//        }
//
//        for (Map.Entry<TypeChambre, Integer> entry : chambresParType.entrySet()) {
//            TypeChambre type = entry.getKey();
//            int count = entry.getValue();
//            double pourcentage = (count * 100.0) / totalChambres;
//            log.info("Le pourcentage des chambres pour le type " + type + " est égale à " + String.format("%.1f", pourcentage));
//        }
//    }


}
