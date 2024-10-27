package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@Tag(name="Gestion Bloc")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {

    IBlocService blocService;


    @Operation(description = "récuperer toutes les blocs de la bd")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return  blocService.retrieveAllBlocs();

    }

    @Operation(description = "récuperer bloc par id")
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long chId) {
        return blocService.retrieveBloc(chId);

    }

    @Operation(description ="ajout  bloc")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc c) {
        return blocService.addBloc(c);

    }

    @Operation(description ="supression de bloc")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long chId) {
        blocService.removeBloc(chId);
    }

    @Operation(description ="modification de bloc")
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc c) {
        return blocService.modifyBloc(c);
    }
}
