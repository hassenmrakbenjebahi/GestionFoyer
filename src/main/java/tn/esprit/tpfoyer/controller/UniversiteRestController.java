package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;

import java.util.List;

@Tag(name="Gestion Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {

    IUniversiteService universiteService;

    // http://localhost:8089/tpfoyer/universite/retrieve-all-universites
    @Operation(description = "récuperer toutes les universites de la bd")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.retrieveAllUniversites();
        return listUniversites;
    }
    // http://localhost:8089/tpfoyer/universite/retrieve-universite/8
    @Operation(description = "récuperer universite par id")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long chId) {
        Universite universite = universiteService.retrieveUniversite(chId);
        return universite;
    }
    // http://localhost:8089/tpfoyer/universite/add-universite
    @Operation(description ="ajout  universite")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite c) {
        Universite universite = universiteService.addUniversite(c);
        return universite;
    }
    // http://localhost:8089/tpfoyer/universite/remove-universite/{universite-id}
    @Operation(description ="supression de universite")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long chId) {
        universiteService.removeUniversite(chId);
    }
    // http://localhost:8089/tpfoyer/universite/modify-universite
    @Operation(description ="modification de universite")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite c) {
        Universite universite = universiteService.modifyUniversite(c);
        return universite;
    }
}
