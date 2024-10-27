package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@Tag(name="Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {

    IFoyerService foyerService;

    // http://localhost:8089/tpfoyer/foyer/retrieve-all-foyers
    @Operation(description = "récuperer toutes les foyers de la bd")
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        return foyerService.retrieveAllFoyers();

    }
    // http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8
    @Operation(description = "récuperer foyer par id")
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long chId) {
        return foyerService.retrieveFoyer(chId);

    }
    // http://localhost:8089/tpfoyer/foyer/add-foyer
    @Operation(description ="ajout  foyer")
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer c) {
        return foyerService.addFoyer(c);

    }
    // http://localhost:8089/tpfoyer/foyer/remove-foyer/{foyer-id}
    @Operation(description ="supression de foyer")
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long chId) {
        foyerService.removeFoyer(chId);
    }
    // http://localhost:8089/tpfoyer/foyer/modify-foyer
    @Operation(description ="modification de foyer")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer c) {
        return foyerService.modifyFoyer(c);

    }
}
