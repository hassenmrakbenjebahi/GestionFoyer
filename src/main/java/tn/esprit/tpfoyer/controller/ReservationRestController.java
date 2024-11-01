package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@Tag(name="Gestion Reservation")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {

    IReservationService reservationService;

    @Operation(description = "récuperer toutes les reservations de la bd")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        return reservationService.retrieveAllReservations();

    }

    @Operation(description = "récuperer reservation par id")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long chId) {
        return reservationService.retrieveReservation(chId);

    }

    @Operation(description ="ajout  reservation")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation c) {
        return reservationService.addReservation(c);

    }

    @Operation(description ="supression de reservation")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long chId) {
        reservationService.removeReservation(chId);
    }

    @Operation(description ="modification de reservation")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation c) {
        return reservationService.modifyReservation(c);

    }
}
