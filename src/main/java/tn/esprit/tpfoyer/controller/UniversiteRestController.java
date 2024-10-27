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


    @Operation(description = "récuperer toutes les universites de la bd")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();

    }

    @Operation(description = "récuperer universite par id")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long chId) {
        return universiteService.retrieveUniversite(chId);

    }

    @Operation(description ="ajout  universite")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite c) {
        return universiteService.addUniversite(c);

    }

    @Operation(description ="supression de universite")
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long chId) {
        universiteService.removeUniversite(chId);
    }

    @Operation(description ="modification de universite")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite c) {
        return universiteService.modifyUniversite(c);

    }
}
