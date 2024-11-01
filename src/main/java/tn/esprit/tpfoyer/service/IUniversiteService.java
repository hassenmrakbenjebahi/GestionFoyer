package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {
     List<Universite> retrieveAllUniversites();
     Universite retrieveUniversite(Long universiteId);
     Universite addUniversite(Universite c);
     void removeUniversite(Long universiteId);
     Universite modifyUniversite(Universite universite);
}
