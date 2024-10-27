package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.BlocRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BlocServiceImpl implements IBlocService {
    BlocRepository blocRepository;

    public List<Bloc> retrieveAllBlocs() {

        return blocRepository.findAll();

    }
    public Bloc retrieveBloc(Long blocId) {
        var blocOptional = blocRepository.findById(blocId);
        if (blocOptional.isPresent()) {
            return blocOptional.get();
        } else {
            throw new RuntimeException("Bloc avec l'id " + blocId + " n'existe pas.");
        }
    }    public Bloc addBloc(Bloc c) {
        return blocRepository.save(c);
    }
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }
}
