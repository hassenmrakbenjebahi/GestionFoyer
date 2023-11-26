package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BlocServiceImpl implements IBlocService {
    BlocRepository blocRepository;
    @Scheduled(cron = "0 * * * * *") // Exécute toutes les minutes

    public List<Bloc> retrieveAllBlocs() {
         List<Bloc> bloc=blocRepository.findAll();
        for (Bloc b:bloc
             ) {
            log.info("bloc :" + b);
        }
        return blocRepository.findAll();

    }
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }
    public Bloc addBloc(Bloc c) {
        return blocRepository.save(c);
    }
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
}
