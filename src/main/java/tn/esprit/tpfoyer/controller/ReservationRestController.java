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

    // http://localhost:8089/tpreservation/reservation/retrieve-all-reservations
    @Operation(description = "récuperer toutes les reservations de la bd")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations() {
        List<Reservation> listReservations = reservationService.retrieveAllReservations();
        return listReservations;
    }
    // http://localhost:8089/tpreservation/reservation/retrieve-reservation/8
    @Operation(description = "récuperer reservation par id")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") Long chId) {
        Reservation reservation = reservationService.retrieveReservation(chId);
        return reservation;
    }
    // http://localhost:8089/tpreservation/reservation/add-reservation
    @Operation(description ="ajout  reservation")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.addReservation(c);
        return reservation;
    }
    // http://localhost:8089/tpreservation/reservation/remove-reservation/{reservation-id}
    @Operation(description ="supression de reservation")
    @DeleteMapping("/remove-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") Long chId) {
        reservationService.removeReservation(chId);
    }
    // http://localhost:8089/tpreservation/reservation/modify-reservation
    @Operation(description ="modification de reservation")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation c) {
        Reservation reservation = reservationService.modifyReservation(c);
        return reservation;
    }
}
